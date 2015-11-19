package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class ShrinkNet extends AbstractAction {


    private GameWorld gw;

    public  ShrinkNet(){

        super("Shrink Net");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.contract();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
