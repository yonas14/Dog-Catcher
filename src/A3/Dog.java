package A3;

import java.awt.*;

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
    public void draw(Graphics g,Dimension d) {
        g.setColor(getColor());
        g.drawOval((int) getLocationX(), (int) getLocationY(), 2, 2);
        g.fillOval((int) getLocationX() - getSize()/2, (int)getLocationY()- getSize()/2,getSize(),getSize());


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

    @Override
    public void draw(Graphics g) {
        int halfSize = getSize()/2;
        System.out.println("I am here Yona ");
        if(isSelected()){
            g.setColor(Color.CYAN);
            g.fillOval((int)getLocationX()- halfSize, (int)getLocationY() - halfSize, getSize(), getSize());
        }else{
            g.setColor(getColor());
            g.fillOval((int)getLocationX()- halfSize, (int)getLocationY() - halfSize, getSize(), getSize());
        }

    }
}
