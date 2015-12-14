package a4;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by yoni on 9/15/15.
 */
public class Cat extends Animal implements IDrawable{

    @Override
    public String toString() {
        return ("a1.Cat: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection() );

    }

    @Override
    public void draw(Graphics2D g2d) {
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

//        int halfSize = getSize()/2;
//        g.setColor(getColor());
//
//        Point top      = new Point((int)getLocationX(), (int)getLocationY() + halfSize);
//        Point botLeft  = new Point((int)getLocationX() - halfSize, (int)getLocationY() - halfSize);
//        Point botRight = new Point((int)getLocationX() + halfSize, (int)getLocationY() - halfSize);
//
//        int [] xPts = new int [] {top.x, botLeft.x, botRight.x} ;
//        int [] yPts = new int [] {top.y, botLeft.y, botRight.y} ;
//
//        g.fillPolygon(xPts, yPts, 3);

        AffineTransform saveAT = g2d.getTransform();

        // add current objects transformations
        g2d.transform(getTranslate());
        g2d.transform(getRotation());
        g2d.transform(getScale());



        // prep for drawing beak
        final int [] xBeakPoints = {0, -(getSize()/4), (getSize()/4) };
        final int [] yBeakPoints = { getSize(), (int)(getSize()*0.3), (int)(getSize()*0.3) };

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(xBeakPoints, yBeakPoints, 3);

//        g.drawRect((int) getLocationX()-getSize()/2, (int)getLocationY()+ getSize()/2, 15, 15);
//        g.setColor(Color.black);
//
//        final int [] xBeakPoints = {0, -(getSize()/4), (getSize()/4) };
//        final int [] yBeakPoints = { getSize(), (int)(getSize()*0.3), (int)(getSize()*0.3) };
//
//        g.setColor(Color.DARK_GRAY);
//        g.fillPolygon(xBeakPoints, yBeakPoints, 3);

        g2d.setTransform(saveAT);
    }



    @Override
    public void move() {

    }

//    @Override
//    public boolean collidesWith(GameObject obj) {
//
//        boolean result = false;
//        float thisCenterX = this.getLocationX() + (getSize()/2); // find centers
//        float thisCenterY = this.getLocationY() + (getSize()/2);
//
//        float otherCenterX = obj.getLocationX() + (obj.getSize()/2);
//        float otherCenterY = obj.getLocationY() + (obj.getSize()/2);
//
//        float dx = thisCenterX - otherCenterX;
//        float dy = thisCenterY - otherCenterY;
//        float distBetweenCentersSqr = (dx*dx + dy*dy);
//
//        int thisRadius = getSize()/2;
//        int otherRadius = obj.getSize()/2;
//
//        int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
//
//        if (distBetweenCentersSqr <= radiiSqr) { result = true ; }
//
//        return result;
//
//    }
//
//    @Override
//    public void handleCollision(GameObject obj) {
//        if(obj instanceof Dog){
//            obj.setColor(Color.gray);
//        }

  //  }
}
