import java.util.ArrayList;

public interface GameRules {
    ArrayList<Coordinates> decideCellFate(CellGrid cellGrid);
}
