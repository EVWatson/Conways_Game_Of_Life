import java.util.ArrayList;

public class ConwaysGameOfLifeGameRules implements GameRules{

    public ArrayList<Coordinates> decideCellFate(CellGrid cellGrid){
        ArrayList<Coordinates> nextGenerationOfLiveCells = new ArrayList<>();

        for(int cellRow = 0; cellRow < cellGrid.getNumberOfRows()-1; cellRow++) {
            for (int cellCol = 0; cellCol < cellGrid.getNumberOfColumns()-1; cellCol++) {
                boolean cellIsAlive = cellGrid.getCellIsAlive(cellRow, cellCol);
                Coordinates currentCellCoordinates = new Coordinates(cellRow, cellCol);

                int numberOfLiveNeighbours = NeighbourChecker.determineTotalNumberOfLiveNeighbours(cellGrid, currentCellCoordinates);

                if (numberOfLiveNeighbours == 3) {
                    nextGenerationOfLiveCells.add(new Coordinates(cellRow, cellCol));
                }
                if(cellIsAlive && numberOfLiveNeighbours == 2) {
                    nextGenerationOfLiveCells.add(new Coordinates(cellRow, cellCol));
                }
            }
        }
        return nextGenerationOfLiveCells;
    }

}
