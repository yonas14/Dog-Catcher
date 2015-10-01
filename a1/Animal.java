package a1;

import java.util.Random;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Animal extends GameObject implements IMoveable{

    private int speed,direction;
    private Random rand;

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
/*

    public void move() {
        float locationX =-1;
        float locationY=-1;
        rand = new Random();

        while( !( (locationX >= 0 && locationX <=1024) && (locationY >= 0 && locationY <= 1024) &&(speed == 5) ) ){
           locationX = rand.nextInt(speed)+rand.nextFloat();
           locationY = rand.nextInt(speed)+rand.nextFloat();
        }
        setLocation(locationX,locationY);
        setDirection(rand.nextInt(360));
    }*/

    public void move(){

        if((getLocationX()>= 0 && getLocationX() <=1024) && (getLocationX()>= 0 && getLocationX() <= 1024)){
            float dx= (float) Math.cos(90-getLocationX())*speed;
            float dy= (float) Math.sin(90-getLocationY())*speed;

            setLocation((getLocationX()+dx),(getLocationY()+dy));
            //setDirection(rand.nextInt(360));
        }


    }
}
