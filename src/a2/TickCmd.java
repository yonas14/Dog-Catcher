package a2;

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

        gw.clockTick();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
