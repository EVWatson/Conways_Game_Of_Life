public class Cell {

    private boolean isAlive;

    public Cell (){

        this.isAlive = false;
    }

    public boolean getIsAlive() {

        return isAlive;
    }



    public void changeState(){
        if (!this.isAlive){
            this.isAlive = true;
        }
        else {
            this.isAlive = false;
        }

//        this.isAlive = !(this.isAlive);
    }



}
