public enum ErrorMessage {

    INCORRECT_GRID_DIMENSIONS("Input must be number,number; please try again"),
    INCORRECT_COORDINATE_FORMAT("Input must be number,number|number,number; please try again"),
    INCORRECT_COORDINATES("Coordinates cannot be outside grid dimensions; please try again");

    private String errMessage;

    ErrorMessage(String errMessage){

        this.errMessage = errMessage;
    }

    public String getErrMessage() {

        return errMessage;
    }
}
