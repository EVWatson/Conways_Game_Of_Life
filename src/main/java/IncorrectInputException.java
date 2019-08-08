public class IncorrectInputException extends Exception {

    public IncorrectInputException(String errorMessage) {
        super(errorMessage);
    }

    public IncorrectInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
