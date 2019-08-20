
public interface UserInputManager {
    String getUserInput();
    Boolean validateStringInput(String input);
    String getCorrectUserInput(String error) throws InvalidUserInputException;
}
