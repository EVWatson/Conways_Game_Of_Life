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

    private static ArrayList<Boolean> getStateOfSurroundingNeighbours(CellGrid cellGrid, ArrayList<Coordinates> neighbourLocations) {
        ArrayList<Boolean> neighbourStates = new ArrayList<>();
        for (Coordinates location : neighbourLocations) {
            neighbourStates.add(cellGrid.getCellIsAlive(location.getX(), location.getY()));
        }
        return neighbourStates;
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


    public static Coordinates convertToWrappedCoordinates(CellGrid cellGrid, int originalX, int originalY) {

        int newX = originalX;
        int newY = originalY;

        if (originalX == -1) {
            newX = cellGrid.getNumberOfRows() - 1;
        }
        if (originalX == (cellGrid.getNumberOfRows() - 1) + 1) {
            newX = 0;
        }
        if (originalY == -1) {
            newY = cellGrid.getNumberOfColumns() - 1;
        }
        if (originalY == (cellGrid.getNumberOfColumns() - 1) + 1) {
            newY = 0;
        }
        return new Coordinates(newX, newY);
    }
}