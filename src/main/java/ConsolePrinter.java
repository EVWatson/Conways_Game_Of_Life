public class ConsolePrinter implements Printer{

//    naming - especially printString
//    rename class to outputManage?

    public void print(String string){
        System.out.println(string);
        System.out.flush();
    }

}
