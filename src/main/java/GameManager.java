import java.util.ArrayList;
import java.util.function.Function;

public class GameManager {
   private GameRules gameRules;
//   private CellGrid cellGrid;
   private UserInputManager userInputManager;
   private Printer consolePrinter = new ConsolePrinter();

    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }

//    look up curses library for console display. ping andrew g when everything is on fire

//   error handler class?

//    handle interrupedException, and array out of bounds exception

    public void runGame()throws InterruptedException, InvalidUserInputException {
        int[] dimensions;
        try {
            dimensions = initialiseGridSize();
        } catch (InvalidUserInputException error){
            throw error;
        }
        CellGrid cellGrid = new CellGrid(dimensions[0], dimensions[1]);
        ArrayList<Coordinates> coords = nominateActiveCells();
        try {
            cellGrid.setCellState(coords);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new InvalidUserInputException(ErrorMessage.INCORRECT_COORDINATES.getErrMessage());
        }

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = createNextGeneration(cellGrid);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Do you want to stop the program?");
                // get input
                // if yes, rethrow exception
                // if no, do nothing
            }
        }
    }

//    handle exceptions?? incorrect input = try again?

//    lots of duplicate code here.

    private int[] initialiseGridSize() throws InvalidUserInputException {
        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        int attemptsLeft = 3;
        while(attemptsLeft > 0){
            String input = this.userInputManager.getUserInput();
            if (this.userInputManager.validateStringInput(input)) {
                return InputTranslator.splitStringIntoIntegers(input);
            } else {
                System.out.println(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage());
                attemptsLeft--;
            }
        }
        throw new InvalidUserInputException("Attempt limit exceeded");
    }

    private ArrayList<Coordinates> nominateActiveCells() {
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        String input = this.userInputManager.getUserInput();
        try {
            if(!this.userInputManager.validateStringInput(input)){
                throw new InvalidUserInputException(ErrorMessage.INCORRECT_COORDINATE_FORMAT.getErrMessage());
            }
        }
        catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
        return InputTranslator.splitStringIntoCoordinates(input);
    }

    private void printCurrentGrid(CellGrid cellGrid) {
        System.out.println("\n");
        String [][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
        consolePrinter.print(CellGridTranslator.formatStringGridAsSingleString(printableCellGrid));
    }

    private CellGrid createNextGeneration(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellState(nextGenCells);
        return cellGrid;
    }
}
