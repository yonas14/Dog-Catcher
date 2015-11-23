package A3;

import java.awt.*;

/**
 * Created by yoni on 9/15/15.
 */
public class Cat extends Animal implements IDrawable, ICollider {

    @Override
    public String toString() {
        return ("a1.Cat: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection() );

    }

    @Override
    public void draw(Graphics g,Dimension d) {
//        g.setColor(getColor());
//
//        float height = (float) d.getHeight();
//
//
//        float x1 = (getLocationX() + (getSize()/2));
//        float y1 = height - ((float) (getLocationY() - (getSize()/ 2) * Math.sqrt(3)));
//
//
//        float x2 = (int)getLocationX();
//        float y2 = height - (getLocationY());
//
//
//        float x3 = getLocationX() + (getSize());
//        float y3 = height - (getLocationY());
//
//        int x[] = {(int) x1,(int)x2,(int)x3};
//        int y[] = {(int)y1,(int)y2,(int)y3};
//
//        int n = 3;
//
//
//
//        Polygon p = new Polygon(x,y, n);
//
//        g.drawPolygon(p);

        int halfSize = getSize()/2;
        g.setColor(getColor());

        Point top      = new Point((int)getLocationX(), (int)getLocationY() + halfSize);
        Point botLeft  = new Point((int)getLocationX() - halfSize, (int)getLocationY() - halfSize);
        Point botRight = new Point((int)getLocationX() + halfSize, (int)getLocationY() - halfSize);

        int [] xPts = new int [] {top.x, botLeft.x, botRight.x} ;
        int [] yPts = new int [] {top.y, botLeft.y, botRight.y} ;

        g.drawPolygon(xPts, yPts, 3);

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
        if(obj instanceof Dog){
            obj.setColor(Color.gray);
        }

    }
}
