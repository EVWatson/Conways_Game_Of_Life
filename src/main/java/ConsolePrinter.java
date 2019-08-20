public class ConsolePrinter implements Printer{

//    naming - especially printString
//    rename class to outputManage?

    public void print(String string){
        System.out.println(string);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
