package com.emily.conways.service;

import com.emily.conways.exception.InvalidUserInputException;
import com.emily.conways.model.CellGrid;
import com.emily.conways.model.Coordinates;
import com.emily.conways.service.input.InputTranslator;
import com.emily.conways.service.input.UserInputManager;
import com.emily.conways.service.output.CellGridTranslator;
import com.emily.conways.service.output.ConsoleOutputManager;
import com.emily.conways.service.output.OutputManager;
import com.emily.conways.utils.ErrorMessage;
import com.emily.conways.utils.MessagesToPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameManager {
    private GameRules gameRules;
    private UserInputManager userInputManager;
    private OutputManager consoleConsoleOutputManager = new ConsoleOutputManager();


    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }

    public void runGame() throws InterruptedException, InvalidUserInputException, IOException {
        int[] dimensions = initialiseGridSize();
        CellGrid cellGrid = new CellGrid(dimensions[0], dimensions[1]);
        ArrayList<Coordinates> coordinates = nominateActiveCells(cellGrid);
        cellGrid.setCellStateAsAlive(coordinates);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!bufferedReader.ready()) {
                printCurrentGrid(cellGrid);
                cellGrid = createNextGeneration(cellGrid);
                Thread.sleep(34);
            }
        } finally {
            bufferedReader.close();
        }
    }

    private int[] initialiseGridSize() throws InvalidUserInputException {
        consoleConsoleOutputManager.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        String validatedInput = userInputManager.getCorrectUserInput(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage());
        return InputTranslator.splitStringIntoIntegers(validatedInput);
    }

    private ArrayList<Coordinates> nominateActiveCells(CellGrid cellGrid) throws InvalidUserInputException {
        consoleConsoleOutputManager.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        return userInputManager.getCorrectCoordinates(cellGrid);
    }

    private void printCurrentGrid(CellGrid cellGrid) {
        System.out.println("\n");
        String[][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
        consoleConsoleOutputManager.clearScreen();
        consoleConsoleOutputManager.print(CellGridTranslator.formatStringArrayAsSingleString(printableCellGrid) + "\nPress return to quit");
    }

    private CellGrid createNextGeneration(CellGrid cellGrid) {
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellStateAsAlive(nextGenCells);
        return cellGrid;
    }

}

