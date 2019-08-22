import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NeighbourCheckerTest {

    @Test
    public void whenCellHasNoLiveNeighboursDetermineNumberOfLiveNeighboursReturnsNoLiveNeighbours() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, 1);

        int expectedLiveNeighbours = 0;
        int actualLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid, coordinates);

        assertEquals(expectedLiveNeighbours, actualLiveNeighbours);

    }

    @Test
    public void whenCellHasLiveNeighboursDetermineNumberOfLiveNeighboursReturnsTheNumberOfLiveNeighbours() {
        CellGrid cellGrid = new CellGrid(3, 3);

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(0, 1));
        coordinates.add(new Coordinates(1, 0));
        coordinates.add(new Coordinates(1, 2));
        cellGrid.setCellStateAsAlive(coordinates);

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
    public void whenCellGridHasLessThanEightCellsGetCoordinatesOfNeighboursWillReturnArrayListOfSizeEight() {
        CellGrid cellGrid = new CellGrid(1, 1);
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
    public void whenCellIsOnTheFirstRowNeighboursAboveWrapToLastRow() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(-1, 1);

        Coordinates expectedResult = new Coordinates(2, 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenCellInOnTheFirstColumnNeighboursToTheLeftWrapToLastColumn() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(1, -1);

        Coordinates expectedResult = new Coordinates(1, 2);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheLastRowNeighboursBelowWrapToFirstRow() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(3, 1);

        Coordinates expectedResult = new Coordinates(0, 1);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
    }

    @Test
    public void whenCellIsOnTheLastColumnNeighboursToTheRightWrapToFirstColumn() {
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

    @Test
    public void whenCellIsOnTheTopRightCornerNeighbourToTheTopRightCornerWrapsToTheBottomLeftCorner() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(-1, 3);

        Coordinates expectedResult = new Coordinates(cellGrid.getNumberOfRows() - 1, 0);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
        assertEquals(expectedResult.getY(), actualResult.getY());
    }

    @Test
    public void whenCellIsOnTheBottomRightCornerNeighbourToTheBottomRightCornerWrapsToTheTopLeftCorner() {
        CellGrid cellGrid = new CellGrid(3, 3);
        Coordinates coordinates = new Coordinates(3, 3);

        Coordinates expectedResult = new Coordinates(0, 0);
        Coordinates actualResult = NeighbourChecker.convertToWrappedCoordinates(cellGrid, coordinates.getX(), coordinates.getY());

        assertEquals(expectedResult.getX(), actualResult.getX());
        assertEquals(expectedResult.getY(), actualResult.getY());
    }

}