package A3;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Catcher extends GameObject implements IGuideable
{


    public void moveRight(){
        setLocation(getLocationX()+5,getLocationY());
    }

    public void moveLeft(){
        setLocation(getLocationX()-5,getLocationY());
    }
    public void moveDown(){
        setLocation(getLocationX(),getLocationY()+5);

    }
    public void moveUp(){

        setLocation(getLocationX(),getLocationY()-5);
    }

    public void expand(){
        setSize(getSize()+15);

    }

    public void contract(){
        setSize(getSize()-15);

    }

}
