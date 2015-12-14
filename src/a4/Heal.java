package a4;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 11/18/15.
 */
public class Heal extends AbstractAction{

    private static GameWorld game;

    public Heal(){

        super("Heal");
    }




    public void actionPerformed(ActionEvent e){
        game.healDogs();
    }

    public void setGame(GameWorld gameWorld) {
        this.game = gameWorld;
    }
}
