import java.util.ArrayList;

public interface UserInputManager {
    int[] getCellGridDimensions() throws IncorrectInputException;
    ArrayList<Coordinates> getCoordinatesList() throws IncorrectInputException;
}
