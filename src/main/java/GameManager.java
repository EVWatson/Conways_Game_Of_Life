import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameManager {
   private GameRules gameRules;
   private UserInputManager userInputManager;
   private Printer consolePrinter = new ConsolePrinter();


    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }

    public void runGame()throws InterruptedException, InvalidUserInputException, IOException {
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
        }
        finally {
            bufferedReader.close();
        }
    }

    private int[] initialiseGridSize()throws InvalidUserInputException{
        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        String validatedInput = userInputManager.getCorrectUserInput(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage());
        return InputTranslator.splitStringIntoIntegers(validatedInput);
    }

    private ArrayList<Coordinates> nominateActiveCells(CellGrid cellGrid)throws InvalidUserInputException {
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        return userInputManager.getCorrectCoordinates(cellGrid);
    }

    private void printCurrentGrid(CellGrid cellGrid) {
        System.out.println("\n");
        String [][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
        consolePrinter.clearScreen();
        consolePrinter.print(CellGridTranslator.formatStringArrayAsSingleString(printableCellGrid) + "\nPress return to stop program");
    }

    private CellGrid createNextGeneration(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellStateAsAlive(nextGenCells);
        return cellGrid;
    }
}

//    private ArrayList<Coordinates> nominateActiveCells()throws InvalidUserInputException {
//        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
//        String validatedStringInput = userInputManager.getCorrectUserInput(ErrorMessage.INCORRECT_COORDINATE_FORMAT.getErrMessage());
//        return InputTranslator.splitStringIntoCoordinates(validatedStringInput);
//    }

//    private void applyCoordinates(CellGrid cellGrid, ArrayList<Coordinates> initialCoordinates)throws InvalidUserInputException{
//        int attempts = 3;
//        while (attempts > 0) {
//            try {
//                cellGrid.setCellStateAsAlive(initialCoordinates);
//                break;
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println(ErrorMessage.INCORRECT_COORDINATES.getErrMessage());
//                attempts--;
//                if(attempts == 0) {
//                    throw new InvalidUserInputException(ErrorMessage.EXCEEDED_ATTEMPT_LIMIT.getErrMessage());
//                }
//                initialCoordinates = nominateActiveCells();
//            }
//        }
//    }
