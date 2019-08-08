import org.junit.Test;

import static org.junit.Assert.*;

public class CellGridTest {

    @Test
    public void cellGridInitialisesWithSpecifiedNumberOfRowsOfCells(){

        CellGrid cellGrid = new CellGrid(6,6);

        int expectedRows = 6;
        int actualRows = cellGrid.getNumberOfRows();

        assertEquals(expectedRows, actualRows);
    }

    @Test
    public void cellGridInitialisesWithSpecifiedNumberOfColumnsOfCells(){

        CellGrid cellGrid = new CellGrid(6,6);

        int expectedColumns = 6;
        int actualColumns = cellGrid.getNumberOfColumns();

        assertEquals(expectedColumns, actualColumns);
    }

    @Test
    public void cellGridCanInitialiseWithMoreRowsThanColumns(){
        CellGrid cellGrid = new CellGrid(6,5);

        int expectedRows = 6;
        int actualRows = cellGrid.getNumberOfRows();

        assertEquals(expectedRows, actualRows);
    }

    @Test
    public void cellGridCanInitialiseWithMoreColumnsThanRows(){
        CellGrid cellGrid = new CellGrid(6, 7);

        int expectedColumns = 7;
        int actualColumns = cellGrid.getNumberOfColumns();

        assertEquals(expectedColumns, actualColumns);
    }

    @Test
    public void getCellIsDeadReturnsCurrentStateOfCellAtSpecifiedCoordinates(){
        CellGrid cellGrid = new CellGrid(6,6);
        boolean cellIsAlive = cellGrid.getCellIsAlive(2,2);
        assertFalse(cellIsAlive);
    }

//    validate minimum acceptable grid dimensions

//    @Test
//    public void ifDimensionsAreLessThanOneAndOneThrowsException(){
//
//    }


}