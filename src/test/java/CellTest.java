import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CellTest {

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