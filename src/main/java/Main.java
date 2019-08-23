import java.io.IOException;

public class Main {

    public static void main(String[] args)  throws InterruptedException, InvalidUserInputException, IOException {

    GameRules gameRules = new ConwaysGameOfLifeGameRules();
    UserInputManager inputManager = new ConsoleInputManager();
    GameManager gameManager = new GameManager(gameRules, inputManager);

    gameManager.runGame();
    }

}
