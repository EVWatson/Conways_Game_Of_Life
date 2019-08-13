import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NeighbourCheckerTest {

    @Test
    public void whenCellHasNoLiveNeighboursDetermineNumberOfLiveNeighboursReturnsZero() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, 1);

        int expectedLiveNeighbours = 0;
        int actualLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid, coordinates);

        assertEquals(expectedLiveNeighbours, actualLiveNeighbours);

    }

    @Test
    public void whenCellHasLiveNeighboursDetermineNumberOfLiveNeighboursWillReturnTheNumberOfLiveNeighbours() {
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> liveCells = new ArrayList<>();
        liveCells.add(new Coordinates(0, 1));
        liveCells.add(new Coordinates(1, 0));
        liveCells.add(new Coordinates(1, 2));
        cellGrid.setCellState(liveCells);

        Coordinates coordinatesOfCellToCheck = new Coordinates(1, 1);

        int expectedLiveNeighbours = 3;
        int actualLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid, coordinatesOfCellToCheck);

        assertEquals(expectedLiveNeighbours, actualLiveNeighbours);
    }

    @Test
    public void getCoordinatesOfNeighboursWillReturnArrayListOfSizeEight() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, 1);

        ArrayList<Coordinates> neighbourLocations = NeighbourChecker.getCoordinatesOfNeighbours(cellGrid, coordinates);

        int expectedSize = 8;
        int actualSize = neighbourLocations.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void whenCellNeighbourDoesNotNeedToBeWrappedOriginalCoordinatesAreReturned() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates expectedCoordinates = new Coordinates(1, 1);

        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, expectedCoordinates.getX(), expectedCoordinates.getY());

        assertEquals(expectedCoordinates.getX(), actualResult.getX());
        assertEquals(expectedCoordinates.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheFirstRowAnyNeighboursAboveWrapToLastRow() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(-1, 1);

        Coordinates expectedResult = new Coordinates(2, 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenCellInOnTheFirstColumnAnyNeighboursToTheLeftWrapToLastColumn() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, -1);

        Coordinates expectedResult = new Coordinates(1, 2);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheLastRowAnyNeighboursBelowWrapToFirstRow() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(3, 1);

        Coordinates expectedResult = new Coordinates(0, 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenCellIsOnTheLastColumnAnyNeighboursToTheRightWrapToFirstColumn() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, 2 + 1);

        Coordinates expectedResult = new Coordinates(2, 0);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheTopLeftCornerNeighbourToTheTopLeftCornerWrapsToTheBottomRightCorner() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(-1, -1);

        Coordinates expectedResult = new Coordinates(cellGrid.getNumberOfRows() - 1, cellGrid.getNumberOfColumns() - 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
        assertEquals(expectedResult.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheBottomLeftCornerNeighbourToTheBottomLeftCornerWrapsToTheTopRightCorner() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(3, -1);

        Coordinates expectedResult = new Coordinates(0, cellGrid.getNumberOfColumns() - 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
        assertEquals(expectedResult.getY(), actualResult.getY());
    }

}