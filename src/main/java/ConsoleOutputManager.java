public class ConsoleOutputManager implements OutputManager {

    public void print(String string) {
        System.out.println(string);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
