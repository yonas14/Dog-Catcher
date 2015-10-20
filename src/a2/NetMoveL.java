package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class NetMoveL extends AbstractAction{

    private GameWorld gw;

    public NetMoveL(){

        super("Move Left");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.left();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }


}
