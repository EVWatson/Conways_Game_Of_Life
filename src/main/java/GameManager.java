import java.util.ArrayList;

public class GameManager {
   private GameRules gameRules;
   private CellGrid cellGrid;

    public GameManager(GameRules gameRules) {

        this.gameRules = gameRules;
    }


//   error handler class?


    public void initiateGame(){

        PrintToConsole.enterDimensionsInstruction();

        int[] value = {};
        try {
            value = UserInputManager.getCellGridDimensions();
        }
        catch (IncorrectInputException message){
            System.err.println(message.getMessage());
        }

        PrintToConsole.enterLiveCellCoordinates();

        cellGrid = new CellGrid(value[0], value[1]);

        ArrayList<Coordinates> coords = new ArrayList<>();

        try {
             coords = UserInputManager.getCoordinatesOfLiveCells();
        }
        catch (IncorrectInputException message){
            System.err.println(message.getMessage());
        }

        cellGrid.setCellState(coords);
    }

    public void runGame() throws InterruptedException{


        for (int turns = 0; turns < 20; turns++) {

            System.out.println("\n");
            String [][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
            PrintToConsole.printString(CellGridTranslator.formatStringGridAsSingleString(printableCellGrid));

            cellGrid = updateCells(cellGrid);

            Thread.sleep(1000);

        }
    }

    private CellGrid updateCells(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellState(nextGenCells);
        return cellGrid;
    }
}
