import java.util.ArrayList;

public class GameManager {
   private GameRules gameRules;
   private CellGrid cellGrid;
   private UserInputManager userInputManager;

    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }


//   error handler class?

//    handle interrupedException

    public void runGame() {

        int[] value = initialiseGridSize();
        cellGrid = new CellGrid(value[0], value[1]);
        ArrayList<Coordinates> coords = nominateActiveCells();
        cellGrid.setCellState(coords);

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = updateGrid(cellGrid);
            Thread.sleep(1000);
        }
    }

//    handle exceptions?? incorrect input = try again?

    private ArrayList<Coordinates> nominateActiveCells() {
        PrintToConsole.enterLiveCellCoordinates();
        return this.userInputManager.getCoordinatesList();
    }

    private int[] initialiseGridSize()  {
        PrintToConsole.enterDimensionsInstruction();
        return this.userInputManager.getCellGridDimensions();
    }

    private void printCurrentGrid(CellGrid cellGrid) {
        System.out.println("\n");
        String [][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
        PrintToConsole.printString(CellGridTranslator.formatStringGridAsSingleString(printableCellGrid));
    }

    private CellGrid updateGrid(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellState(nextGenCells);
        return cellGrid;
    }
}
