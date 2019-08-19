import java.util.*;

public class ConsoleInputManager implements UserInputManager {

    public String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public Boolean validateStringInput(String input) throws InvalidUserInputException {

        if (input.matches("([1-9]\\d*,[1-9]\\d*\\|?)+?")) {
            return true;
        } else {
            if (input.contains("|")) {
                throw new InvalidUserInputException(ErrorMessage.INCORRECT_COORDINATE_FORMAT.getErrMessage());
            }
            throw new InvalidUserInputException(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage());
        }
    }

}



