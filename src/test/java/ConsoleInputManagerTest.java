import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleInputManagerTest {

    @Test
    public void givenStringIsValidWhenFormatIsNumberCommaNumber() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "1,1";
        assertTrue(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsValidWhenNumbersAreDoubleDigits() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "10,10";
        assertTrue(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsValidWhenNumbersAreSingleAndDoubleDigits() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "10,8";
        assertTrue(userInputManager.validateStringInput(input));
    }


    @Test
    public void givenStringIsValidWhenAPairOfCoordinatesIsSeparatedByAPipe() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String inputWithPipe = "1,1|2,2";
        assertTrue(userInputManager.validateStringInput(inputWithPipe));
    }

    @Test
    public void givenStringIsValidWhenMultipleCoordinatesAreSeparatedByMultiplePipes() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String inputWithPipe = "1,1|2,2|3,3";
        assertTrue(userInputManager.validateStringInput(inputWithPipe));
    }

    @Test
    public void givenStringIsValidWhenNumbersAreRepeated() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "11,11";
        assertTrue(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenFirstNumberIsLessThanOne() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "0,2";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenSecondNumberIsLessThanOne() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "2,0";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenAnyNumberIsLessThanOne() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "2,4|0,3";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenNumbersAreNotSeparatedByAComma() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "4 4";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenMultipleNumberPairsAreNotSeparatedByAPipe() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "4,4,5,5";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenIncorrectDelimitersAreGiven() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "4,4 5'5";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenInputContainsLetter() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "a,4";
        assertFalse(userInputManager.validateStringInput(input));
    }

    @Test
    public void givenStringIsNotValidWhenInputContainsSymbol() {
        UserInputManager userInputManager = new ConsoleInputManager();
        String input = "@,4";
        assertFalse(userInputManager.validateStringInput(input));
    }

}