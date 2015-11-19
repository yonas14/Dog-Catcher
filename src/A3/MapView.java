package A3;

import a2.*;
import com.sun.javafx.collections.ObservableSetWrapper;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by School on 10/17/15.
 */

//MapView class containing code to output the map
public class MapView extends JPanel implements IObserver{
    private Collection c;
    private GameWorld gw;
    private ObjectCollection obj;
//    private IIterator itr;


    MapView(){
        setBackground(Color.white);
    }





    public void paintComponent(Graphics g){
        super.paintComponent(g);

        IIterator itr = obj.getIterator();
        while (itr.hasNext()){
            Object obj = itr.getNext();
            if(obj instanceof Dog){
                Dog dog =(Dog)obj;
                dog.draw(g,this.getSize());
            }else if (obj instanceof Cat){
                Cat cat = (Cat)obj;
                //System.out.println("draw cat");
                cat.draw(g,this.getSize());

            }else if(obj instanceof Net){
                Net net = (Net)obj;
               // System.out.println("draw net");
                net.draw(g,this.getSize());

            }

        }


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
}
