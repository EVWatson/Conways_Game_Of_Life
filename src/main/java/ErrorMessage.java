public enum ErrorMessage {

    INCORRECT_GRID_DIMENSIONS("Input must be number,number: please try again"),
    INCORRECT_COORDINATES("Input must be number,number|number,number: please try again");

    private String errMessage;

    ErrorMessage(String errMessage){
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
