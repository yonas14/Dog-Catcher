package a4;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class TickCmd extends AbstractAction {
    private GameWorld gw;
    private static int tickInterval = 0;
    private static int tickCount = 0;


    public  TickCmd(){

        super("Tick");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        //gw.clockTick(mapView.getSize().width, mapView.getSize().height);
        //gw.clockTick(mapView.getSize().width, mapView.getSize().height);

        if(gw != null && tickInterval > 0){


            // actually tick the game clock & move objects
            gw. clockTick(tickInterval);

            // update the views
            gw.notifyObservers();

        } else{
            System.out.println("Command received to advance game clock, but a GameWorld target has been set,");
            System.out.println("or the interval has not been properly set in the TickCommand class...");
        }
    }


    public static void setInterval(int ms){
        tickInterval = ms;
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
