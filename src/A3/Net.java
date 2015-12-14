package A3;

import java.awt.*;

/**
 * Created by yoni on 9/15/15.
 */
public class Net extends Catcher implements IDrawable {

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
        g.drawRect((int)getLocationX(), (int)getLocationY(), 2, 2);
        g.drawRect((int)getLocationX()-(getSize()/2),(int)getLocationY()-(getSize()/2),getSize(),getSize());

    }



}
