
public interface UserInputManager {
    String getUserInput();
    Boolean validateStringInput(String input)throws InvalidUserInputException;
}
