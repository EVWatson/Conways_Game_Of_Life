import java.util.ArrayList;

public class InputTranslater {


    public static int[] splitStringIntoIntegers(String inputValues) {
        String[] splitUserInput = inputValues.split(",");
        int[] intArray = new int[2];
            intArray[0] = Integer.parseInt(splitUserInput[0]);
            intArray[1] = Integer.parseInt(splitUserInput[1]);
        return intArray;
    }

//    use first part of above method in below method for second string split

        public static ArrayList<Coordinates> splitStringIntoCoordinates (String inputValues){
            ArrayList<Coordinates> coordinates = new ArrayList<>();
            String[] splitIntoPairs = inputValues.split("[| ]");
                for (String pair : splitIntoPairs) {
                    int[] integers = splitStringIntoIntegers(pair);
                    coordinates.add(new Coordinates((integers[0] - 1), (integers[1]) - 1));
                }
            return coordinates;
        }
    }
