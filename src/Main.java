public class Main {

    public static void main(String[] args) {

        CellGrid cellGrid = new CellGrid();

        String[][] newCellGrid = CellAndGridFormatter.getCellGridAsStringArray(cellGrid);

        ConsolePrinter.printGridWithFormatting(newCellGrid);

    }
}
