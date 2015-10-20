package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class ScoopCmd extends AbstractAction{
    private GameWorld gw;

    public ScoopCmd(){

        super("Scoop");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.scoop();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
