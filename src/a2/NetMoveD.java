package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class NetMoveD extends AbstractAction{
    private GameWorld gw;

    public  NetMoveD(){

        super("Move Down");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.down();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
