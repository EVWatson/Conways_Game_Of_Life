import java.util.*;

public class ConsoleInputManager implements UserInputManager {

//    make user input separate entirely from validation?? still difficult to test as methods with user input are calling methods that i could test..


//    think about how refactor exceptions
//

    private static ArrayList<Coordinates> coordinates = new ArrayList<>();

    public int[] getCellGridDimensions() throws IncorrectInputException {
        Scanner userInput = new Scanner(System.in);
        String[] splitUserInput = userInput.next().split(",");
        return validateCellGridDimensions(splitUserInput);
    }

    public ArrayList<Coordinates> getCoordinatesList() throws IncorrectInputException{
        Scanner userInput = new Scanner(System.in);
        String[] splitIntoPairs = userInput.next().split("[| ]");
        splitArrayIntoCoordinates(splitIntoPairs);
        return coordinates;
    }

    private static int[] validateCellGridDimensions(String[] inputValues) throws IncorrectInputException{
        int[] cellGridDimensions = new int[2];
        if(inputValues.length == 2){
            try {
                cellGridDimensions[0] = Integer.parseInt(inputValues[0]);
                cellGridDimensions[1] = Integer.parseInt(inputValues[1]);
            }
            catch (NumberFormatException e){
                throw new IncorrectInputException("Input must be number,number: please try again", e);
            }
        }
        else {
            throw new IncorrectInputException("Input must be number,number: please try again");
        }
        return cellGridDimensions;
    }

    private static void splitArrayIntoCoordinates(String[] coordinatePairs) throws IncorrectInputException {
        if (coordinatePairs.length >= 1) {
            try {
                for (String pair : coordinatePairs) {
                    String[] splitPair = pair.split(",");
                    // validate pair?
                    coordinates.add(new Coordinates((Integer.parseInt(splitPair[0])-1), (Integer.parseInt(splitPair[1]))-1));
                }
            }
            catch(NumberFormatException e) {
                throw new IncorrectInputException("Input must be number,number|number,number: please try again", e);
            }
        }
        else {
            throw new IncorrectInputException("Input must be number,number|number,number: please try again");
        }
    }
}



