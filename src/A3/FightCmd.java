package A3;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/19/15.
 */
public class FightCmd extends AbstractAction {
    private GameWorld gw;

    public  FightCmd(){

        super("Dog/Cat Fight");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        gw.fight();
        gw.map();
    }

    public void setGameWorld(GameWorld g){

        gw = g;

    }
}
