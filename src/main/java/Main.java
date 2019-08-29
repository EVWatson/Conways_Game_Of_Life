import com.emily.conways.exception.InvalidUserInputException;
import com.emily.conways.service.ConwaysGameOfLifeGameRules;
import com.emily.conways.service.GameManager;
import com.emily.conways.service.GameRules;
import com.emily.conways.service.input.ConsoleInputManager;
import com.emily.conways.service.input.UserInputManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, InvalidUserInputException, IOException {

        GameRules gameRules = new ConwaysGameOfLifeGameRules();
        UserInputManager inputManager = new ConsoleInputManager();
        GameManager gameManager = new GameManager(gameRules, inputManager);

        gameManager.runGame();
    }

}
