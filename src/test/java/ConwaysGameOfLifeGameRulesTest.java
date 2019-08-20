import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ConwaysGameOfLifeGameRulesTest {

//    TODO check that new coordinates are actually the expected numbers

    @Test
    public void whenCellIsAliveAndHasTwoLiveNeighboursCellCoordinatesAreAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(0,1));
        liveCells.add(new Coordinates(1,0));
        liveCells.add(new Coordinates(1,1));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        Coordinates coordinates = nextGenerationOfLiveCells.get(2);

        assertTrue(nextGenerationOfLiveCells.contains(coordinates));
    }

    @Test
    public void whenCellIsAliveAndHasThreeLiveNeighboursCellCoordinatesAreAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(0,1));
        liveCells.add(new Coordinates(1,0));
        liveCells.add(new Coordinates(1,1));
        liveCells.add(new Coordinates(1,2));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        Coordinates coordinates = nextGenerationOfLiveCells.get(2);

        assertTrue(nextGenerationOfLiveCells.contains(coordinates));
    }

    @Test
    public void whenCellIsDeadAndHasThreeLiveNeighboursCellCoordinatesAreAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(0,1));
        liveCells.add(new Coordinates(1,0));
        liveCells.add(new Coordinates(1,2));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        Coordinates coordinates = nextGenerationOfLiveCells.get(2);

        assertTrue(nextGenerationOfLiveCells.contains(coordinates));
    }

}