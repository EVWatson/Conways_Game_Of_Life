
public class Main {

    public static void main(String[] args)  throws InterruptedException, InvalidUserInputException{

    GameRules gameRules = new ConwaysGameOfLifeGameRules();
    UserInputManager inputManager = new ConsoleInputManager();
    GameManager gameManager = new GameManager(gameRules, inputManager);

    gameManager.runGame();

    }
}
