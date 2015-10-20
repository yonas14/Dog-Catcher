package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class KittenCollison extends AbstractAction {

    private GameWorld gw;

    public  KittenCollison(){

        super("Kitten Collision");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.expand();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
