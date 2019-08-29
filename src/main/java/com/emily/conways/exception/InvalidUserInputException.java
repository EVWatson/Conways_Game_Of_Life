package com.emily.conways.exception;//The com.emily.conways.exception.InvalidUserInputException is a customised exception for handling incorrect user input, providing a more detailed description of the error.

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException(String message) {
        super(message);
    }

}
