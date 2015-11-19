package a2;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by School on 10/17/15.
 */

//MapView class containing code to output the map
public class MapView extends JPanel implements Observer {

    MapView(Observable o){
        setBackground(Color.gray);
        o.addObserver(this);
    }






    @Override
    public void update(Observable o, Object arg) {

    }
}
