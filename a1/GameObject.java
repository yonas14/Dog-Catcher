package a1;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class GameObject
{

    private Vector<Float> location;
    private Random rand;
    private Color color;
    private int size;

    public GameObject (){
        location = new Vector<>();
        location.setSize(2);
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Vector<Float> getLocation() {
        return location;
    }

    public void setLocation(Vector<Float> location) { //
        this.location = location;
    }

    public void setLocation(float x, float y){
        location.set(0,x);
        location.set(1,y);

    }

    public void randLocation(){
        rand = new Random();
        this.setLocation(rand.nextFloat()*1024,rand.nextFloat()*1024);

    }

    public float getLocationX(){
        return location.get(0);
    }
    public float getLocationY(){
        return location.get(1);
    }

}
