package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class KittenCollision extends AbstractAction {

    private GameWorld gw;

    public KittenCollision(){

        super("Kitten Collision");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.makeKitten();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}


