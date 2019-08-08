import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ConwaysGameOfLifeGameRulesTest {

//    cellgrid
//    rules of the game

    @Test
    public void whenCellIsAliveAndHasLessThanTwoLiveNeighboursCoordinatesAreNotAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);
        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(1,1));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);

        assertFalse(nextGenerationOfLiveCells.contains(new Coordinates(1,1)));

    }

    @Test
    public void whenCellIsAliveAndHasGreaterThanThreeLiveNeighboursCellCoordinatesAreNotAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(1,2));
        liveCells.add(new Coordinates(2,1));
        liveCells.add(new Coordinates(2,2));
        liveCells.add(new Coordinates(2,3));
        liveCells.add(new Coordinates(3,2));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);

        assertFalse(nextGenerationOfLiveCells.contains(new Coordinates(1,1)));
    }

    @Test
    public void whenCellIsAliveAndHasTwoOrThreeLiveNeighboursCellCoordinatesAreAddedToNextGenerationArrayList(){
        ConwaysGameOfLifeGameRules conwaysGameOfLifeGameRules = new ConwaysGameOfLifeGameRules();
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(1,2));
        liveCells.add(new Coordinates(2,1));
        liveCells.add(new Coordinates(2,2));
        liveCells.add(new Coordinates(2,3));
        cellGrid.setCellState(liveCells);

        ArrayList<Coordinates> nextGenerationOfLiveCells = conwaysGameOfLifeGameRules.decideCellFate(cellGrid);
        System.out.println(nextGenerationOfLiveCells.size());

        for(Coordinates xy : nextGenerationOfLiveCells) {
            System.out.println(xy.getX() + " " + xy.getY());
        }



    }

//    @Test
//    public void whenCellIsDeadAndHasThreeLiveNeighboursCellBecomesAlive(){
//        ConwaysGameOfLifeGameRules gameRules = new ConwaysGameOfLifeGameRules();
//        CellGrid cellGrid = new CellGrid(3, 3);
//
//        ArrayList<Coordinates> liveCells = new ArrayList<>();
//        liveCells.add(new Coordinates(1,1));
//        liveCells.add(new Coordinates(2,2));
//        liveCells.add(new Coordinates(1,3));
//        cellGrid.setCellState(liveCells);
//
//
//        gameRules.decideCellFate(cellGrid);
//
//        assertTrue(cellGrid.getCellIsAlive(0,1));
//
//    }


}