package A3;

import a2.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Animal extends GameObject implements IMoveable, ICollider {

    private int speed,direction;
    private Random rand = new Random();
    private float  tempX;
    private float tempY;
    private float dx;
    private float dy;
    private boolean collision;
    private final int WIDTH = 894;
    private final int HEIGHT = 950;

    public GameWorld getGw() {
        return gw;
    }

    public void setGw(GameWorld gw) {
        this.gw = gw;
    }

    private GameWorld gw;

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


    @Override
    public boolean collidesWith(ICollider otherObject) {
        float p1x = getLocationX();
        float p2x = getLocationX() + getSize();
        float p3x = getLocationX();
        float p4x = getLocationX() + getSize();
        float p1y = getLocationY();
        float p2y = getLocationY();
        float p3y = getLocationY() + getSize();
        float p4y = getLocationY() + getSize();


        Animal animal = (Animal) otherObject;
        float a1x = animal.getLocationX();
        float a2x = animal.getLocationX() + animal.getSize();
        float a3x = animal.getLocationX();
        float a4x = animal.getLocationX() + getSize();
        float a1y = animal.getLocationY();
        float a2y = animal.getLocationY();
        float a3y = animal.getLocationY() + animal.getSize();
        float a4y = animal.getLocationY() + animal.getSize();

        if ((p1x > a1x && p1x < a2x) && (p1y > a1y && p1y < a3y) ||//good
                (p2x > a1x && p2x < a2x) && (p2y > a1y && p2y < a3y) ||//good
                (p3x > a1x && p3x < a2x) && (p3y > a1y && p3y < a3y) ||//good
                (p4x > a1x && p4x < a2x) && (p4y > a1y && p4x < a3x)) { //good

           // System.out.println("collision");
            collision = true;
            return true;
        } else {
            collision = false;
            return false;
        }
    }

    public void handleCollision(ICollider otherObject) {
     //   Dog currDog = (Dog)otherObject;
        if (otherObject instanceof Dog){
            Random random = new Random ();
            int rand = random.nextInt(254);
            Dog doggy=(Dog) otherObject;
//System.err.println(rand);
            if(doggy.getSpeed() > 0) {

                doggy.setSpeed(getSpeed() - 1);
                //doggy.setLocation(getLocationX()+100, getLocationY()+100);
                System.out.println(doggy.getSpeed());

            }
            if (doggy.getSpeed() <= 0){
                System.out.println(doggy.getSpeed());
                rand = 0;
            }
//            System.out.println(doggy.getSpeed());
//            System.out.println(rand);
            doggy.setColor(Color.YELLOW);
        }else if (otherObject instanceof Cat) {

            gw.makeKitten();
        }

    }





}
