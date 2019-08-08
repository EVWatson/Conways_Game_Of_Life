public class Cell {

    private Boolean isAlive;


    public Cell(Boolean isAlive){

        this.isAlive = isAlive;
    }

    public Boolean getIsAlive() {

        return isAlive;
    }

    public void setCellToAlive(){

        this.isAlive = true;
    }

}
