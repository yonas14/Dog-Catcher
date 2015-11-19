package A3;

import java.awt.*;

/**
 * Created by yoni on 9/15/15.
 */
public class Net extends Catcher implements IDrawable, ICollider {

    @Override
    public String toString() {
        return ("a1.Net: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize());

    }

    @Override
    public void draw(Graphics g, Dimension d) {
//        graphics.drawRect((int)getLocationX(),(int)getLocationY(), (int)getLocationX()+getSize()/2, (int)getLocationY()+getSize()/2);
//        graphics.setColor(Color.RED);
//        graphics.fillRect((int)getLocationX(),(int)getLocationY(), (int)getLocationX()+getSize()/2, (int)getLocationY()+getSize()/2);

        g.setColor(getColor());
        //g.drawRect(getSize(), getSize(), getSize(), getSize());
        g.fillRect((int)getLocationX(),(int)getLocationY(),getSize(),getSize());

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
