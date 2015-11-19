package a1;

import java.util.Random;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class Animal extends GameObject implements IMoveable{

    private int speed,direction;
    private Random rand;
    private float  tempX;
    private float tempY;
    private float dx;
    private float dy;

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




        float deltaX = (float)Math.cos(90 - getDirection())*getSpeed();
        float deltaY = (float)Math.sin(90 - getDirection())*getSpeed();
        float newLocationX = (getLocationX()+deltaX);
        float newLocationY = (getLocationY()+deltaY);

		/*if(newLocationX == 1024-(getSize()/2) || newLocationX == getSize()/2 || newLocationY == 1024-(getSize()/2) || newLocationY == getSize()/2){
			setDirection(rand.nextInt(360));
			move();
		}*/

        if( newLocationX < 1024-(this.getSize()/2) && newLocationX > (this.getSize()/2) && newLocationY < 1024-(this.getSize()/2) && newLocationY > (this.getSize()/2)){
            setLocation(newLocationX,newLocationY);
        }


//        rand = new Random();
//        dx= (float) Math.cos(90-getLocationX())*speed;
//        dy= (float) Math.sin(90-getLocationY())*speed;
//        tempX = getLocationX()+tempX;
//        tempY = getLocationY()+tempY;
//
//        if(tempX < getSize()/2){
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
//            setDirection(rand.nextInt(360));


    }
}
