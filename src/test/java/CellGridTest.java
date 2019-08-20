import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CellGridTest {

    @Test
    public void cellGridInitialisesWithSpecifiedNumberOfRows(){

        CellGrid cellGrid = new CellGrid(6,6);

        int expectedRows = 6;
        int actualRows = cellGrid.getNumberOfRows();

        assertEquals(expectedRows, actualRows);
    }

    @Test
    public void cellGridInitialisesWithSpecifiedNumberOfColumns(){

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
    public void cellGridCanInitialiseWithMoreColumnsThanRows() {
        CellGrid cellGrid = new CellGrid(6, 7);

        int expectedColumns = 7;
        int actualColumns = cellGrid.getNumberOfColumns();

        assertEquals(expectedColumns, actualColumns);
    }

    @Test
    public void cellStateIsSetToDeadUponInitialisationOfCellGrid(){
        CellGrid cellGrid = new CellGrid(6,6);
        boolean cellIsDead = cellGrid.getCellIsAlive(2,2);
        assertFalse(cellIsDead);
    }

    @Test
    public void cellStateIsSetToAliveAtSpecifiedCoordinates(){
        CellGrid cellGrid = new CellGrid(6,6);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(0, 1));
        cellGrid.setCellState(liveCells);

        assertTrue(cellGrid.getCellIsAlive(0,1));
    }








}