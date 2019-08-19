import java.util.ArrayList;

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
        int[] dimensions = initialiseGridSize();
       CellGrid cellGrid = new CellGrid(dimensions[0], dimensions[1]);
        ArrayList<Coordinates> coords = nominateActiveCells();
        cellGrid.setCellState(coords);

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = createNextGeneration(cellGrid);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new InterruptedException("Do you want to stop the program?");
            }
        }
    }

//    handle exceptions?? incorrect input = try again?

//    lots of duplicate code here.

    private int[] initialiseGridSize() {
        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        String input = this.userInputManager.getUserInput();
        try {
            this.userInputManager.validateStringInput(input);
        }
        catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
        return InputTranslater.splitStringIntoIntegers(input);
    }

    private ArrayList<Coordinates> nominateActiveCells() throws InvalidUserInputException{
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        String input = this.userInputManager.getUserInput();
        try {
            this.userInputManager.validateStringInput(input);
        }
        catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidUserInputException(ErrorMessage.INCORRECT_COORDINATES.getErrMessage(), e);
        }
        return InputTranslater.splitStringIntoCoordinates(input);
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
