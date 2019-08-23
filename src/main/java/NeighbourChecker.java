import java.util.ArrayList;

public class NeighbourChecker {

    public static int determineTotalNumberOfLiveNeighbours(CellGrid cellGrid, Coordinates currentCellCoordinates) {
        int totalLiveNeighbours = 0;

        ArrayList<Coordinates> neighbourLocations = getCoordinatesOfNeighbours(cellGrid, currentCellCoordinates);
        ArrayList<Boolean> neighbourStates = getStateOfSurroundingNeighbours(cellGrid, neighbourLocations);

        for (Boolean stateIsAlive : neighbourStates) {
            if (stateIsAlive) {
                totalLiveNeighbours += 1;
            }
        }
        return totalLiveNeighbours;
    }

    public static ArrayList<Coordinates> getCoordinatesOfNeighbours(CellGrid cellGrid, Coordinates currentCellCoordinates) {
        ArrayList<Coordinates> neighbourLocations = new ArrayList<>();

        int x = currentCellCoordinates.getX();
        int y = currentCellCoordinates.getY();

        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x - 1, y));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x - 1, y + 1));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x, y + 1));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x + 1, y + 1));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x + 1, y));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x + 1, y - 1));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x, y - 1));
        neighbourLocations.add(convertToWrappedCoordinates(cellGrid, x - 1, y - 1));

        return neighbourLocations;
    }

    public static Coordinates convertToWrappedCoordinates(CellGrid cellGrid, int originalXCoordinate, int originalYCoordinate) {
        int newXCoordinate = originalXCoordinate;
        int newYCoordinate = originalYCoordinate;

        if (originalXCoordinate == -1) {
            newXCoordinate = cellGrid.getNumberOfRows() - 1;
        }
        if (originalXCoordinate == (cellGrid.getNumberOfRows() - 1) + 1) {
            newXCoordinate = 0;
        }
        if (originalYCoordinate == -1) {
            newYCoordinate = cellGrid.getNumberOfColumns() - 1;
        }
        if (originalYCoordinate == (cellGrid.getNumberOfColumns() - 1) + 1) {
            newYCoordinate = 0;
        }
        return new Coordinates(newXCoordinate, newYCoordinate);
    }

    private static ArrayList<Boolean> getStateOfSurroundingNeighbours(CellGrid cellGrid, ArrayList<Coordinates> neighbourLocations) {
        ArrayList<Boolean> neighbourStates = new ArrayList<>();
        for (Coordinates location : neighbourLocations) {
            neighbourStates.add(cellGrid.getCellIsAlive(location.getX(), location.getY()));
        }
        return neighbourStates;
    }

}