//The UnableToValidateInputException is a customised exception for handling incorrect user input, providing a more detailed description of the error.

public class UnableToValidateInputException extends Exception {

    public UnableToValidateInputException(String message) {
        super(message);
    }

    public UnableToValidateInputException(String message, Throwable cause) {

        super(message, cause);
    }

}
