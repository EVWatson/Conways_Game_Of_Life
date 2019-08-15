import java.util.ArrayList;

public class GameManager {
   private GameRules gameRules;
   private CellGrid cellGrid;
   private UserInputManager userInputManager;
   private Printer consolePrinter = new ConsolePrinter();

    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }

//    look up curses library for console display. ping andrew g when everything is on fire

//   error handler class?

//    handle interrupedException, and array out of bounds exception

    public void runGame() {
        int[] dimensions = initialiseGridSize();
        cellGrid = new CellGrid(dimensions[0], dimensions[1]);
        ArrayList<Coordinates> coords = nominateActiveCells();
        cellGrid.setCellState(coords);

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = createNextGeneration(cellGrid);
//            Thread.sleep(1000);
        }
    }

//    handle exceptions?? incorrect input = try again?

    private int[] initialiseGridSize(){
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        String input = this.userInputManager.getUserInput();
        this.userInputManager.validateStringInput(input);
        return InputTranslater.splitStringIntoIntegers(input);
    }

    private ArrayList<Coordinates> nominateActiveCells() {
        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        String input = this.userInputManager.getUserInput();
        this.userInputManager.validateStringInput(input);
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
