package a4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Collection;

/**
 * Created by School on 10/17/15.
 */

//MapView class containing code to output the map
public class MapView extends JPanel implements IObserver{
    private Collection c;
    private GameWorld gw;
    private ObjectCollection obj;
    private double winLeft, winRight, winTop, winBot;
    private AffineTransform worldToND, ndToScreen, theVTM;
    private Dog a = new Dog();



//    private IIterator itr;


    MapView(Dog d){
        setBackground(Color.white);
       // a = d;
        System.out.println(a.getHEIGHT() +" "+ a.getWIDTH());

        winLeft = winBot = 0;
        winRight = a.getWIDTH();
        winTop = a.getHEIGHT();
    }





    public void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g;
        AffineTransform saveAT = g2d.getTransform();

        double winHeight = winTop - winBot;
        double winWidth = winRight - winLeft;

        // update the VTM for window
        worldToND = buildWorldToNDXform(winWidth, winHeight, winLeft, winBot);
        ndToScreen = buildNDToScreenXform( this.getWidth(), this.getHeight() );
        theVTM = (AffineTransform)ndToScreen.clone();
        theVTM.concatenate(worldToND);
        g2d.transform(theVTM);

        // draw everything
        IIterator anIterator = null;

        // get an iterator for the collection
        anIterator = obj.getIterator();

        // setup a placeholder object
        Object currentObj;

        // iterate through, and print each one
        while( anIterator.hasNext() ){
            currentObj = anIterator.getNext();
            if(currentObj != null){
                // reset the g2d object, and draw next
                g2d.setTransform(theVTM);
                ((GameObject)currentObj).draw(g2d);
            }
        }
        setVisible(true);

        g2d.setTransform(saveAT);


//        IIterator itr = obj.getIterator();
//        while (itr.hasNext()){
//            Object obj = itr.getNext();
//            if(obj instanceof Dog){
//                Dog dog =(Dog)obj;
//                dog.draw(g,this.getSize());
//            }else if (obj instanceof Cat){
//                Cat cat = (Cat)obj;
//                //System.out.println("draw cat");
//                cat.draw(g,this.getSize());
//
//            }else if(obj instanceof Net){
//                Net net = (Net)obj;
//               // System.out.println("draw net");
//                net.draw(g,this.getSize());
//
//            }
//
//        }


    }



    @Override
    public void update(IObservable o) {
        gw = (GameWorld)o;
        obj = gw.getGameObjList();
        //itr = obj.getIterator();
        c= gw.getStart();
       // System.out.println("Wats up GGG");
        repaint();


    }

    // set up the world to ND transform
    public AffineTransform buildWorldToNDXform(double width, double height, double left, double bot){
        AffineTransform theTransform = new AffineTransform();
        theTransform.scale((1/width), (1/height));
        theTransform.translate(-left, -bot);
        return theTransform;
    }

    // set up the ND to Screen transform
    public AffineTransform buildNDToScreenXform(double panelWidth, double panelHeight){
        AffineTransform theTransform = new AffineTransform();
        theTransform.translate(0, panelHeight);
        theTransform.scale(panelWidth, -panelHeight);
        return theTransform;
    }


    public AffineTransform getVTM(){
        return new AffineTransform(theVTM);
    }
    // zooms in 5%
    public void zoomIn(){
        double h = winTop - winBot;
        double w = winRight - winLeft;
        winLeft += w*0.05;
        winRight -= w*0.05;
        winTop -= h*0.05;
        winBot += h*0.05;
        this.repaint();
    }

    // zooms out 5%
    public void zoomOut(){
        double h = winTop - winBot;
        double w = winRight - winLeft;
        winLeft -= w*0.05;
        winRight += w*0.05;
        winTop += h*0.05;
        winBot -= h*0.05;
        this.repaint();
    }

    public void panLeft(){
        winLeft += 15;
        winRight += 15;
    }

    public void panRight(){
        winLeft -= 15;
        winRight -= 15;
    }

    public void panUp(){
        winTop -= 15;
        winBot -= 15;
    }

    public void panDown(){
        winTop += 15;
        winBot += 15;
    }
}
