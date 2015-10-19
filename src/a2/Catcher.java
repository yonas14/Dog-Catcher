package a2;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Catcher extends GameObject implements IGuideable
{


    public void moveRight(){
        setLocation(getLocationX()+4f,getLocationY());
    }

    public void moveLeft(){
        setLocation(getLocationX()-4f,getLocationY());
    }
    public void moveDown(){
        setLocation(getLocationX(),getLocationY()-4f);

    }
    public void moveUp(){

        setLocation(getLocationX(),getLocationY()+4f);
    }

    public void expand(){
        setSize(getSize()+15);

    }

    public void contract(){
        setSize(getSize()-15);

    }

}
