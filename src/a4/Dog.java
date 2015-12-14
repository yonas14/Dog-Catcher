package a4;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;


/**
 * Created by yoni on 9/15/15.
 */
public class Dog extends Animal implements IDrawable, ISelectable {

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
    public void draw(Graphics2D g2d) {

//        AffineTransform saveAT= g.getTransform();
//
//        g.transform(getRotation());
//        g.transform(getTranslate());
//        g.transform(getScale());
//
//        g.setColor(getColor());
//        g.drawLine(0, 0, 0, 30);
//
//        g.drawOval((-getSize()/2), ((-getSize()/2)), 2, 2);
//        g.fillOval( (-getSize()/2) , - (getSize()/2),getSize(),getSize());
//
//        g.setColor(Color.black);


        // save the AT for restoration later
        AffineTransform saveAT = g2d.getTransform();

        // add current objects transformations
        g2d.transform(getTranslate());
        g2d.transform(getRotation());
        g2d.transform(getScale());

        // draw filled in circle/oval to represent the bird body
        g2d.setColor(getColor());
        g2d.fillOval(-(getSize()/2), -(getSize()/2), getSize(), getSize());

        // prep for drawing beak
        final int [] xBeakPoints = {0, -(getSize()/4), (getSize()/4) };
        final int [] yBeakPoints = { getSize(), (int)(getSize()*0.3), (int)(getSize()*0.3) };

        g2d.setColor(Color.pink);
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

    public void setSelected(boolean select) {
        selected = select;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }


    public boolean contains(Point2D.Float p) {
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

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void move() {

    }


    // @Override
    //public void draw(Graphics2D g) {
//        int halfSize = getSize()/2;
//        System.out.println("I am here Yona ");
//        if(isSelected()){
//            g.setColor(Color.CYAN);
//            g.fillOval((int)getLocationX()- halfSize, (int)getLocationY() - halfSize, getSize(), getSize());
//        }else{
//            g.setColor(getColor());
//            g.fillOval((int)getLocationX()- halfSize, (int)getLocationY() - halfSize, getSize(), getSize());
//        }

    //}
}
