package a4;

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
    private int WIDTH ;

    private int HEIGHT;



    public int getWIDTH() {
        return WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    private int heading;

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

    Animal(){
        super();
        setHEIGHT(950);
        setWIDTH(894);
        heading = (randInt(0,359));
        speed = (randInt(5,15));

        rotate(heading);
    }


    public void move(int ms){

//        System.out.println(heading);
//        int angle = 90 - heading;
//        float deltaX = ( ((float)Math.cos((90-getLocationX()) * speed)));
//        float deltaY = ( ((float)Math.sin( (90-getLocationY()))) * speed);
//
//        ///calc for elapsed time (above calc assumes 1 sec)
//        deltaX = ( deltaX * ( (float)ms / 17 ));
//        deltaY = ( deltaY * ( (float)ms / 17 ));
//
//        //System.out.println(deltaX);
//
////        if( WIDTH - deltaX < WIDTH-(this.getSize()/2) &&  deltaX > (this.getSize()/2) ){
//           super.move(deltaX, deltaY);
//           rotate((90-getLocationY()));
////       } else{
////             angle = 90 - heading;
////             deltaX = ( ((float)Math.cos( Math.toRadians(angle) )) * speed);
////             deltaY = ( ((float)Math.sin( Math.toRadians(angle) )) * speed);
////            move(ms);
////
////        }
        int angle = 90 - heading;
        float deltaX = (float)Math.cos(Math.toRadians(angle)) * getSpeed();
        float deltaY = (float)Math.sin(Math.toRadians(angle)) * getSpeed();

        // calc for elapsed time (above calc assumes 1 sec)
        deltaX = deltaX * ( (float)20 / 17 );
        deltaY = deltaY * ( (float)20 / 17 );
//
        float newLocationX = (getLocationX()+deltaX);
        float newLocationY = (getLocationY()+deltaY);
//
        //super.move(deltaX,deltaY);

        if( newLocationX < getWIDTH()-(getSize()/2) && newLocationX > 0 && newLocationY < getHEIGHT()-(getSize()) && newLocationY > 0){
//			setLocation(newLocationX,newLocationY);
            super.move(deltaX,deltaY);
        } else {
            heading = (randInt(0,359));
            rotate(heading);
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
