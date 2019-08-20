import java.util.*;

public class ConsoleInputManager implements UserInputManager {

    public String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public Boolean validateStringInput(String input) {
        return input.matches("([1-9]\\d*,[1-9]\\d*\\|?)+?");
    }

    public String getCorrectUserInput(String error) throws InvalidUserInputException {
        int attemptsLeft = 3;
        while (attemptsLeft > 0) {
            String initialInput = getUserInput();
            if (validateStringInput(initialInput)) {
                return initialInput;
            } else {
                System.out.println(error);
                attemptsLeft--;
            }
        }
        throw new InvalidUserInputException(ErrorMessage.EXCEEDED_ATTEMPT_LIMIT.getErrMessage());
    }

}



