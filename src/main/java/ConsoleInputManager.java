import java.util.*;
import java.util.regex.Pattern;

public class ConsoleInputManager implements UserInputManager {


    public String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public Boolean validateStringInput(String input){
//        ((input != null) && (!input.equals("")));
        if(input.matches("^[1-9]"))
    }



}



