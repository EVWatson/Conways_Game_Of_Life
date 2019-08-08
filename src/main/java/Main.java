
public class Main {

    public static void main(String[] args)throws InterruptedException {

    GameRules gameRules = new ConwaysGameOfLifeGameRules();
    GameManager gameManager = new GameManager(gameRules);

    gameManager.initiateGame();
    gameManager.runGame();



    }
}
