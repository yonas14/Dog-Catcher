package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class NetMoveU extends AbstractAction {
    private GameWorld gw;

    public NetMoveU(){

        super("Move Up");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.up();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
