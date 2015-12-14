package a4;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;
import java.util.Vector;

/**
 * Created by yoni on 9/15/15.
 */
public abstract class GameObject implements IDrawable
{

    private Vector<Float> location;
    private Random rand;
    private Color color;
    private int size;
    private AffineTransform myRotation, myTranslation, myScale;


    public GameObject (){
        location = new Vector<>();
        location.setSize(2);


        // setup my affine transformations
        myRotation = new AffineTransform();
        myTranslation = new AffineTransform();
        myScale = new AffineTransform();

        // be default, objects do not start selected

        // put the object at a random location
        myTranslation.translate( randInt(20,950), randInt(20,895) );
    }

    GameObject(float xPos, float yPos){
        // setup my affine transformations
        myRotation = new AffineTransform();
        myTranslation = new AffineTransform();
        myScale = new AffineTransform();

        myTranslation.translate(xPos, yPos);

        color = new Color(randInt(0,255), randInt(0,255), randInt(0,255));
    }

    GameObject(float xPos, float yPos, Color c){
        // setup my affine transformations
        myRotation = new AffineTransform();
        myTranslation = new AffineTransform();
        myScale = new AffineTransform();

        myTranslation.translate(xPos, yPos);

        color = c;
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
    public void setRandomColor(){
        Color c = new Color(randInt(0,255), randInt(0,255), randInt(0,255));
        setColor(c);
    }

    public static int randInt(int min, int max){

        Random rand = new Random();
        int randNum= rand.nextInt((max-min)+1) +min;
        return randNum;
    }

    public void setLocation(float x, float y){
        myTranslation.setToIdentity();
        myTranslation.translate(x, y);

    }



    public void move(float deltaX, float deltaY){

        myTranslation.translate(deltaX, deltaY);
    }

    public void randLocation(){
        rand = new Random();
        this.setLocation(rand.nextFloat()*700,rand.nextFloat()*700);

    }

    public float getLocationX(){
        return (float)myTranslation.getTranslateX();
    }
    public float getLocationY(){
        return (float)myTranslation.getTranslateY();
    }


    // support for rotation
    public void rotate(double degrees){
        myRotation.setToRotation(Math.toRadians(0-degrees));
        //myRotation.setToRotation(0-degrees);
    }

    // support for translation
    public void translate(double dx, double dy){
        myTranslation.translate(dx, dy);
    }

    // support for scaling
    public void scale(double xVal, double yVal){
        myScale.scale(xVal, yVal);
    }

    public AffineTransform getRotation(){
        return myRotation;
    }

    public AffineTransform getTranslate(){
        return myTranslation;
    }

    public AffineTransform getScale(){
        return myScale;
    }

    public void resetTransform(){
        myRotation.setToIdentity();
        myTranslation.setToIdentity();
        myScale.setToIdentity();
    }


}
