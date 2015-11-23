package A3;

import java.util.Random;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Animal extends GameObject implements IMoveable {

    private int speed,direction;
    private Random rand = new Random();
    private float  tempX;
    private float tempY;
    private float dx;
    private float dy;
    private final int WIDTH = 894;
    private final int HEIGHT = 950;

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


    public void move(){

//        rand = new Random();
//        dx= (float) Math.cos(90-getLocationX())*speed;
//        dy= (float) Math.sin(90-getLocationY())*speed;
//        tempX = getLocationX()+tempX;
//        tempY = getLocationY()+tempY;
//
//        /*if(tempX < getSize()/2){
//            tempX = getSize()/2 + rand.nextFloat()*getSize()/2;
//        }
//        //CHECK RIGHT SIDE
//        else if(tempY > 1024 - (getSize()/2)){
//            tempX = 1024 - (getSize()/2 + rand.nextFloat()*getSize()/2);
//        }
//
//        //CHECK BOTTOM
//        if(tempY < getSize()/2){
//            tempY = getSize()/2 + rand.nextFloat()*getSize()/2;
//        }
//        //CHECK TOP
//        else if(tempY > 1024 - (getSize()/2)){
//            tempY = 1024 - (getSize()/2 + rand.nextFloat()*getSize()/2);
//        }
//
//            setLocation((tempX), (tempY));
//            setDirection(rand.nextInt(360));*/
//

        float deltaX = (float)Math.cos(90 - getDirection())*getSpeed();
        float deltaY = (float)Math.sin(90 - getDirection())*getSpeed();
        float newLocationX = (getLocationX()+deltaX);
        float newLocationY = (getLocationY()+deltaY);
        //System.out.println("IM HERE!");


        if( newLocationX < WIDTH-(this.getSize()/2) && newLocationX > (this.getSize()/2) && newLocationY < HEIGHT-(this.getSize()/2) && newLocationY > (this.getSize()/2)){

            setLocation(newLocationX,newLocationY);
        }
        else{
            setDirection(rand.nextInt(360));
        }



    }


}
