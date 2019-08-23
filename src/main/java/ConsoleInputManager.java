import java.util.*;

public class ConsoleInputManager implements UserInputManager {

    public String getUserInput() {
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

    public ArrayList<Coordinates> getCorrectCoordinates(CellGrid cellGrid)throws InvalidUserInputException {
        int attempts = 3;
        while (attempts > 0) {
            String validatedStringInput = getCorrectUserInput(ErrorMessage.INCORRECT_COORDINATE_FORMAT.getErrMessage());
            ArrayList<Coordinates> initialCoordinates = InputTranslator.splitStringIntoCoordinates(validatedStringInput);
            for (Coordinates coordinates : initialCoordinates) {
                if (coordinates.getX() < cellGrid.getNumberOfRows() && coordinates.getY() < cellGrid.getNumberOfColumns()) {
                    return initialCoordinates;
                } else {
                    System.out.println(ErrorMessage.INCORRECT_COORDINATES.getErrMessage());
                    System.out.println(MessagesToPlayer.ENTER_LIVE_CELL_COORDS.getMessage());
                    attempts--;
                }
            }
        }
        throw new InvalidUserInputException(ErrorMessage.EXCEEDED_ATTEMPT_LIMIT.getErrMessage());
    }

}



