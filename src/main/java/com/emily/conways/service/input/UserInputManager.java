package com.emily.conways.service.input;

import com.emily.conways.exception.InvalidUserInputException;
import com.emily.conways.model.CellGrid;
import com.emily.conways.model.Coordinates;

import java.util.ArrayList;

public interface UserInputManager {
    String getUserInput();
    Boolean validateStringInput(String input);
    String getCorrectUserInput(String error) throws InvalidUserInputException;
    ArrayList<Coordinates> getCorrectCoordinates(CellGrid cellGrid)throws InvalidUserInputException;
}
