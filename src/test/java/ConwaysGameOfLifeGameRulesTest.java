import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ConwaysGameOfLifeGameRulesTest {

    @Test
    public void whenCellIsAliveAndHasTwoLiveNeighboursWillBeAliveInNextGeneration() {
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        int[] currentCellPosition = {1,1};

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0,1));
        coordinates.add(new Coordinates(1,0));
        coordinates.add(new Coordinates(1,1));
        cellGrid.setCellStateAsAlive(coordinates);

        ArrayList<Coordinates> nextGenerationLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        CellGrid updatedGrid = new CellGrid(3,3);
        updatedGrid.setCellStateAsAlive(nextGenerationLiveCells);

        assertTrue(updatedGrid.getCellIsAlive(currentCellPosition[0], currentCellPosition[1]));
    }

    @Test
    public void whenCellIsAliveAndHasThreeLiveNeighboursWillBeAliveInNextGeneration() {
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        int[] currentCellPosition = {1,1};

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0,1));
        coordinates.add(new Coordinates(1,0));
        coordinates.add(new Coordinates(1,1));
        coordinates.add(new Coordinates(1,2));
        cellGrid.setCellStateAsAlive(coordinates);

        ArrayList<Coordinates> nextGenerationLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        CellGrid updatedGrid = new CellGrid(3,3);
        updatedGrid.setCellStateAsAlive(nextGenerationLiveCells);

        assertTrue(updatedGrid.getCellIsAlive(currentCellPosition[0], currentCellPosition[1]));
    }

    @Test
    public void whenCellIsAliveAndHasLessThanTwoLiveNeighboursWillBeDeadNextGeneration() {
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        int[] currentCellPosition = {1,1};

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0,1));
        coordinates.add(new Coordinates(1,1));
        cellGrid.setCellStateAsAlive(coordinates);

        ArrayList<Coordinates> nextGenerationLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        CellGrid updatedGrid = new CellGrid(3,3);
        updatedGrid.setCellStateAsAlive(nextGenerationLiveCells);

        assertFalse(updatedGrid.getCellIsAlive(currentCellPosition[0], currentCellPosition[1]));
    }

    @Test
    public void whenCellIsAliveAndHasMoreThanThreeLiveNeighboursWillBeDeadNextGeneration() {
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        int[] currentCellPosition = {1,1};

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0,1));
        coordinates.add(new Coordinates(1,0));
        coordinates.add(new Coordinates(1,1));
        coordinates.add(new Coordinates(1,2));
        coordinates.add(new Coordinates(2,1));

        cellGrid.setCellStateAsAlive(coordinates);

        ArrayList<Coordinates> nextGenerationLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        CellGrid updatedGrid = new CellGrid(3,3);
        updatedGrid.setCellStateAsAlive(nextGenerationLiveCells);

        assertFalse(updatedGrid.getCellIsAlive(currentCellPosition[0], currentCellPosition[1]));
    }

    @Test
    public void whenCellIsDeadAndHasThreeLiveNeighboursWillBeAliveNextGeneration() {
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        int[] currentCellPosition = {1,1};

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0,1));
        coordinates.add(new Coordinates(1,0));
        coordinates.add(new Coordinates(1,2));
        cellGrid.setCellStateAsAlive(coordinates);

        ArrayList<Coordinates> nextGenerationLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        CellGrid updatedGrid = new CellGrid(3,3);
        updatedGrid.setCellStateAsAlive(nextGenerationLiveCells);

        assertTrue(updatedGrid.getCellIsAlive(currentCellPosition[0], currentCellPosition[1]));
    }

}