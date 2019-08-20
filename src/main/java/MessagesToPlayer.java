public enum MessagesToPlayer {

    ENTER_DIMENSIONS("Please enter dimensions of grid; i.e. rows,columns"),
    ENTER_LIVE_CELL_COORDS("Please enter coordinates of live cells; i.e. x,y|x,y|x,y"),
    STOP_INPUT("Do you want to stop the program? Y/N");

    private String message;

    MessagesToPlayer(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
