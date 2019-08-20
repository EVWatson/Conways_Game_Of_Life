//The InvalidUserInputException is a customised exception for handling incorrect user input, providing a more detailed description of the error.

public class InvalidUserInputException extends Exception {

    public InvalidUserInputException(String message) {

        super(message);
    }

    public InvalidUserInputException(String message, Throwable cause) {

        super(message, cause);
    }

}
