import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NeighbourCheckerTest {

@Test
    public void whenCellHasNoLiveNeighboursDetermineNumberOfLiveNeighboursReturnsZero(){
    CellGrid cellGrid = new CellGrid(3,3);
    Coordinates coordinates = new Coordinates(1,1);

    int expectedLiveNeighbours = 0;
    int actualLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid,coordinates);

    assertEquals(expectedLiveNeighbours, actualLiveNeighbours);

}

@Test
    public void whenCellHasLiveNeighboursDetermineNumberOfLiveNeighboursWillReturnTheNumberOfLiveNeighbours(){
    CellGrid cellGrid = new CellGrid(3,3);
    Coordinates coordinates = new Coordinates(1, 1);

    ArrayList<Coordinates> liveCells = new ArrayList<>();
    liveCells.add(new Coordinates(0,1));
    liveCells.add(new Coordinates(1,0));
    liveCells.add(new Coordinates(1,1));
    liveCells.add(new Coordinates(1,2));
    cellGrid.setCellState(liveCells);

    int expectedLiveNeighbours = 3;
    int actualLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid, coordinates);

    assertEquals(expectedLiveNeighbours, actualLiveNeighbours);

}

//    @Test
//    public void whenCoordinatesDontNeedWrappingConvertToWrappedCoordinatesReturnsOriginalCoordinates(){
//        CellGrid cellGrid = new CellGrid(3,3);
//        Coordinates expectedCoordinates = new Coordinates(1, 1);
//
//        ArrayList<Coordinates> actualResult = NeighbourChecker.getCoordinatesOfNeighbours(cellGrid, expectedCoordinates);
//
//        assertEquals(expectedCoordinates.getX(), actualResult.get(0).getX());
//        assertEquals(expectedCoordinates.getY(), actualResult.get(0).getY());
//    }

    @Test
    public void whenXCoordinateIsFirstRowMinusOneConvertToWrappedCoordinatesWrapsToTheLastRow(){
        CellGrid cellGrid = new CellGrid(3,3);

        Coordinates coordinates = new Coordinates(-1, 1);

        Coordinates expectedResult = new Coordinates(2,1);

        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenYCoordinateIsFirstColumnMinusOneWrapsToLastColumn(){
        CellGrid cellGrid = new CellGrid(3,3);
        Coordinates coordinates = new Coordinates(1, 0-1);
        Coordinates expectedResult = new Coordinates(1,2);

        ArrayList<Coordinates> actualResult = NeighbourChecker.getCoordinatesOfNeighbours(cellGrid, coordinates);

        assertEquals(expectedResult.getY(), actualResult.get(0).getY());
    }

    @Test
    public void whenXCoordinateIsLastRowPlusOneWrapsToFirstRow(){
        CellGrid cellGrid = new CellGrid(3,3);

        Coordinates coordinates = new Coordinates(3, 1);

        Coordinates expectedResult = new Coordinates(0,1);

        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenYCoordinateIsLastColumnPlusOneWrapsToFirstColumn(){
        CellGrid cellGrid = new CellGrid(3,3);
        Coordinates coordinates = new Coordinates(1, 2+1);
        Coordinates expectedResult = new Coordinates(2,0);

        ArrayList<Coordinates> actualResult = NeighbourChecker.getCoordinatesOfNeighbours(cellGrid, coordinates);

        assertEquals(expectedResult.getY(), actualResult.get(0).getY());
    }

}