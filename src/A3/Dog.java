package A3;

import java.awt.*;

/**
 * Created by yoni on 9/15/15.
 */
public class Dog extends Animal implements IDrawable,ICollider {

    private boolean selected;

    private int scratches;



    public int getScratches()
    {
        return scratches;
    }

    public void setScratches(int scratches)
    {
        this.scratches = scratches;
    }

    public void resetScratches() {
        System.out.println("Scratch reseted");
        scratches = 0;
    }


    @Override
    public String toString() {
        return ("a1.Dog: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection()+ " scratches="+ getScratches() );

    }

    @Override
    public void draw(Graphics g,Dimension d) {
        g.setColor(getColor());
        //g.drawOval((int) getLocationX(), (int) getLocationY(), getSize(), getSize());
        g.drawOval((int) getLocationX(), (int) getLocationY(), 2, 2);
        g.drawOval((int) getLocationX() - getSize()/2, (int)getLocationY()- getSize()/2,getSize(),getSize());


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
    public void handleCollision(GameObject obj) {
        if(obj instanceof Cat){
            setColor(Color.blue);


        }

    }
    public void setSelected(boolean select) {
        selected = select;
    }

    public boolean isSelected() {
        return selected;
    }


    public boolean contains(Point p) {
        float x1, x2, y1, y2;
        x1 = getLocationX()-(getSize()/2);
        x2 = getLocationX()+(getSize()/2);
        y1 = getLocationY()-(getSize()/2);
        y2 = getLocationY()+(getSize()/2);

        if(p.getX() >= x1 && p.getX() <= x2){
            if(p.getY() >= y1 && p.getY() <= y2){
                return true;
            }
        }
        return false;
    }
}
