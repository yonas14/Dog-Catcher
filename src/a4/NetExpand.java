package a4;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        gw.map();
    }

    public void setGameWorld(GameWorld g){

       gw = g;

    }
}
