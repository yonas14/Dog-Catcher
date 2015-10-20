package a2;

import a1.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Created by School on 10/19/15.
 */
public class NetExpand extends AbstractAction {

    private GameWorld gw;

   public  NetExpand(){

        super("Net Expand");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.expand();
    }

    public void setGameWorld(GameWorld g){

       gw = g;

    }
}
