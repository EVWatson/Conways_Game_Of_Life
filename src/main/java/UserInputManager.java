import java.util.ArrayList;

public interface UserInputManager {
    String getUserInput();
    Boolean validateStringInput(String input);
    String getCorrectUserInput(String error) throws InvalidUserInputException;
    ArrayList<Coordinates> getCorrectCoordinates(CellGrid cellGrid)throws InvalidUserInputException;
}
