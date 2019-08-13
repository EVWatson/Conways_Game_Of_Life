import java.util.*;

public class ConsoleInputManager implements UserInputManager {



//    think about how refactor exceptions
//



    public String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }


    private static int[] splitStringIntoIntegers(String inputValues) throws UnableToValidateInputException {
        String[] splitUserInput = inputValues.split(",");
        int[] cellGridDimensions = new int[2];
        if(splitUserInput.length == 2){
            try {
                cellGridDimensions[0] = Integer.parseInt(splitUserInput[0]);
                cellGridDimensions[1] = Integer.parseInt(splitUserInput[1]);
            }
            catch (NumberFormatException e){
                throw new UnableToValidateInputException("Input must be number,number: please try again", e);
            }
        }
        else {
            throw new UnableToValidateInputException("Input must be number,number: please try again");
        }
        return cellGridDimensions;
    }

    private static ArrayList<Coordinates> splitStringIntoCoordinates(String inputValues) throws UnableToValidateInputException {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        String[] splitIntoPairs = inputValues.split("[| ]");
        if (splitIntoPairs.length >= 1) {
            try {
                for (String pair : splitIntoPairs) {
                    String[] splitPair = pair.split(",");
                    // validate pair?
                    coordinates.add(new Coordinates((Integer.parseInt(splitPair[0])-1), (Integer.parseInt(splitPair[1]))-1));
                }
            }
            catch(NumberFormatException e) {
                throw new UnableToValidateInputException(ErrorMessage.INCORRECT_GRID_DIMENSIONS.getErrMessage(), e);
            }
        }
        else {
            throw new UnableToValidateInputException(ErrorMessage.INCORRECT_COORDINATES.getErrMessage());
        }
        return coordinates;
    }
}



