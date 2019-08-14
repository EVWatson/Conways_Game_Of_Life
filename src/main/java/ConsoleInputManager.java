import java.util.*;

public class ConsoleInputManager implements UserInputManager {


    public String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public Boolean validateStringInput(String input){
        return (input.matches("([1-9]\\d*,[1-9]\\d*\\|?)+?"));
    }



}



