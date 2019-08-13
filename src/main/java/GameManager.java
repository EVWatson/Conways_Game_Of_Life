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


//   error handler class?

//    handle interrupedException

    public void runGame() throws UnableToValidateInputException{

        int[] value = initialiseGridSize();
        cellGrid = new CellGrid(value[0], value[1]);
//        ArrayList<Coordinates> coords = nominateActiveCells();
//        cellGrid.setCellState(coords);

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = createNextGeneration(cellGrid);
//            Thread.sleep(1000);
        }
    }

//    handle exceptions?? incorrect input = try again?

    private int[] initialiseGridSize()throws UnableToValidateInputException{
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        int[] gridSize = {};
        String input = this.userInputManager.getUserInput();
        try {
            this.userInputManager.validateStringInput(input);
        }
        catch(NumberFormatException e) {
            throw new UnableToValidateInputException(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage(), e);
        }
        return gridSize;
    }

//    private ArrayList<Coordinates> nominateActiveCells() {
//        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
////        return this.userInputManager.getCoordinatesList();
//    }

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
