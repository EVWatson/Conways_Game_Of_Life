import java.util.StringJoiner;

public class CellGridTranslator {

    private static final String ANSI_BROWN = "\033[1;33m";
    private static final String ANSI_GREEN = "\033[1;92m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static String[][] getCellGridAsStringArray(CellGrid cellGrid) {
        String[][] stringCellGrid = new String[cellGrid.getNumberOfRows()][cellGrid.getNumberOfColumns()];

        for (int row = 0; row < cellGrid.getNumberOfRows(); row++) {
            for (int column = 0; column < cellGrid.getNumberOfColumns(); column++) {
                if (cellGrid.getCellIsAlive(row, column)) {
                    stringCellGrid[row][column] = ANSI_GREEN + "o" + ANSI_RESET;
                } else {
                    stringCellGrid[row][column] = ANSI_BROWN + "." + ANSI_RESET;
                }
            }
        }
        return stringCellGrid;
    }

    public static String formatStringArrayAsSingleString(String[][] grid) {
        String gridAsString = "";
        for (String[] row : grid) {
            StringJoiner stringJoiner = new StringJoiner("  ");
            for (String column : row) {
                stringJoiner.add(String.format("%s", column));
            }
            gridAsString = gridAsString.concat(stringJoiner.toString() + "\n");
        }
        return gridAsString;
    }

}
