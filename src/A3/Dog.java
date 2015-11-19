package A3;

import java.awt.*;

/**
 * Created by yoni on 9/15/15.
 */
public class Dog extends Animal implements IDrawable,ICollider {


    private int scratches;



    public int getScratches()
    {
        return scratches;
    }

    public void setScratches(int scratches)
    {
        this.scratches = scratches;
    }


    @Override
    public String toString() {
        return ("a1.Dog: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection()+ " scratches="+ getScratches() );

    }

    @Override
    public void draw(Graphics g,Dimension d) {
        g.setColor(getColor());
        //g.drawOval((int) getLocationX(), (int) getLocationY(), getSize(), getSize());
        g.fillOval((int) getLocationX(), (int)getLocationY(),getSize()*20,getSize()*20);


    }

    @Override
    public boolean collidesWith(GameObject obj) {
        boolean result = false;
        float thisCenterX = this.getLocationX() + (getSize()/2); // find centers
        float thisCenterY = this.getLocationY() + (getSize()/2);

        float otherCenterX = obj.getLocationX() + (obj.getSize()/2);
        float otherCenterY = obj.getLocationY() + (obj.getSize()/2);

        float dx = thisCenterX - otherCenterX;
        float dy = thisCenterY - otherCenterY;
        float distBetweenCentersSqr = (dx*dx + dy*dy);

        int thisRadius = getSize()/2;
        int otherRadius = obj.getSize()/2;

        int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);

        if (distBetweenCentersSqr <= radiiSqr) { result = true ; }

        return result;
    }

    @Override
    public void handleCollision(GameObject otherObject) {

    }
}
