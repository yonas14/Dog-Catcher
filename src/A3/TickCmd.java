package A3;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class TickCmd extends AbstractAction {
    private GameWorld gw;

    public  TickCmd(){

        super("Tick");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        //gw.clockTick(mapView.getSize().width, mapView.getSize().height);
        //gw.clockTick(mapView.getSize().width, mapView.getSize().height);
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
