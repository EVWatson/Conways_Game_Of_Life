public enum ErrorMessage {

    INCORRECT_GRID_DIMENSIONS("Input must be 'number,number' and cannot be 0,0; please try again"),
    INCORRECT_COORDINATE_FORMAT("Input must be 'number,number|number,number'; please try again"),
    INCORRECT_COORDINATES("Coordinates cannot be larger than grid dimensions"),
    EXCEEDED_ATTEMPT_LIMIT("Attempt limit exceeded");

    private String errMessage;

    ErrorMessage(String errMessage){

        this.errMessage = errMessage;
    }

    public String getErrMessage() {

        return errMessage;
    }
}
