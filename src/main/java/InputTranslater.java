import java.util.ArrayList;

public class InputTranslater {


    public static int[] splitStringIntoIntegers(String inputValues) {
        String[] splitUserInput = inputValues.split(",");
        int[] cellGridDimensions = new int[2];
//        if (splitUserInput.length == 2) {
            cellGridDimensions[0] = Integer.parseInt(splitUserInput[0]);
            cellGridDimensions[1] = Integer.parseInt(splitUserInput[1]);

        return cellGridDimensions;
    }

//    use first part of above method in below method for second string split

        public static ArrayList<Coordinates> splitStringIntoCoordinates (String inputValues){
            ArrayList<Coordinates> coordinates = new ArrayList<>();
            String[] splitIntoPairs = inputValues.split("[| ]");
//            if (splitIntoPairs.length >= 1) {
                for (String pair : splitIntoPairs) {
                    String[] splitPair = pair.split(",");
                    // validate pair?
                    coordinates.add(new Coordinates((Integer.parseInt(splitPair[0]) - 1), (Integer.parseInt(splitPair[1])) - 1));
                }
            return coordinates;
        }
    }
