public class PrintToConsole {

//    naming - especially printString
//    rename class to outputManage?



    public static void enterDimensionsInstruction(){
        System.out.println("Please enter dimensions of grid; i.e. rows,columns");
    }

    public static void enterLiveCellCoordinates(){
        System.out.println("Please enter coordinates of live cells; i.e. x,y|x,y|x,y");
    }

    public static void printString(String string){
        System.out.println(string);
        System.out.flush();
    }
}
