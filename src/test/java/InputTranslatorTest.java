import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputTranslatorTest {

    @Test
    public void whenStringHasCommaSplitStringIntoIntegersReturnsArrayOfIntegers() {
        String givenString = "1,1";
        int [] expectedResult = {1,1};
        int [] actualResult = InputTranslator.splitStringIntoIntegers(givenString);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void whenStringHasNoPipeCharacterSplitStringIntoCoordinatesReturnsArrayOfCoordinates() {
        String givenString = "1,1";
        ArrayList<Coordinates> coordinates = InputTranslator.splitStringIntoCoordinates(givenString);
        int expectedArrayListSize = 1;
        int actualArrayListSize = coordinates.size();

        assertEquals(expectedArrayListSize, actualArrayListSize);
    }

    @Test
    public void whenStringHasPipeCharactersSplitStringIntoCoordinatesReturnsArrayOfCoordinates() {
        String givenString = "1,1|2,2|3,3";
        ArrayList<Coordinates> coordinates = InputTranslator.splitStringIntoCoordinates(givenString);
        int expectedArrayListSize = 3;
        int actualArrayListSize = coordinates.size();

        assertEquals(expectedArrayListSize, actualArrayListSize);
    }

}