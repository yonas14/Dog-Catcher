package A3;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class NetMoveR extends AbstractAction{
    private GameWorld gw;

    public NetMoveR(){

        super("Move Right");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.right();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
