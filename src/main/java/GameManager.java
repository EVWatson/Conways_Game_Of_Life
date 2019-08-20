import java.util.ArrayList;


public class GameManager {
   private GameRules gameRules;
   private UserInputManager userInputManager;
   private Printer consolePrinter = new ConsolePrinter();

    //    look up curses library for console display. ping andrew g when everything is on fire


    public GameManager(GameRules gameRules, UserInputManager inputManager) {
        this.gameRules = gameRules;
        this.userInputManager = inputManager;
    }

    public void runGame()throws InterruptedException, InvalidUserInputException {
        int[] dimensions = initialiseGridSize();
        CellGrid cellGrid = new CellGrid(dimensions[0], dimensions[1]);
        ArrayList<Coordinates> coordinates = nominateActiveCells();
        applyValidCoordinates(cellGrid, coordinates);

        for (int turns = 0; turns < 20; turns++) {
            printCurrentGrid(cellGrid);
            cellGrid = createNextGeneration(cellGrid);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Do you want to stop the program? Y/N");
                String answer = userInputManager.getUserInput();
                if(answer.equals("Y")){
                    throw e;
                }
            }
        }
    }

    private int[] initialiseGridSize()throws InvalidUserInputException{
        consolePrinter.print(MessagesToPlayer.ENTER_DIMENSIONS.getMessage());
        String validatedInput = userInputManager.getCorrectUserInput(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage());
        return InputTranslator.splitStringIntoIntegers(validatedInput);
    }

    private ArrayList<Coordinates> nominateActiveCells()throws InvalidUserInputException {
        consolePrinter.print(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
        String validatedStringInput = userInputManager.getCorrectUserInput(ErrorMessage.INCORRECT_COORDINATE_FORMAT.getErrMessage());
        return InputTranslator.splitStringIntoCoordinates(validatedStringInput);
    }

    private void applyValidCoordinates(CellGrid cellGrid, ArrayList<Coordinates> initialCoordinates)throws InvalidUserInputException{
        int attempts = 3;
        while (attempts > 0) {
            try {
                cellGrid.setCellState(initialCoordinates);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(ErrorMessage.INCORRECT_COORDINATES.getErrMessage());
                attempts--;
                if(attempts == 0) {
                    throw new InvalidUserInputException(ErrorMessage.EXCEEDED_ATTEMPT_LIMIT.getErrMessage());
                }
                initialCoordinates = nominateActiveCells();
            }
        }
    }

    private void printCurrentGrid(CellGrid cellGrid) {
        System.out.println("\n");
        String [][] printableCellGrid = CellGridTranslator.getCellGridAsStringArray(cellGrid);
        consolePrinter.print(CellGridTranslator.formatStringArrayAsSingleString(printableCellGrid));
    }

//    move createNextGeneration to cellgrid??

    private CellGrid createNextGeneration(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenCells = gameRules.decideCellFate(cellGrid);
        cellGrid = new CellGrid(cellGrid.getNumberOfRows(), cellGrid.getNumberOfColumns());
        cellGrid.setCellState(nextGenCells);
        return cellGrid;
    }
}
