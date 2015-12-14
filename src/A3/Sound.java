package A3;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * Created by School on 10/20/15.
 */
public class Sound extends AbstractAction {

    private static Sound soundCommand;
    private static GameWorld game;

    private Sound(){
        super("Sound On/Off");
    }

    //ONLY ONE INSTANCE
    public static Sound getInstance(){
        if(soundCommand == null)
            soundCommand = new Sound();
        return soundCommand;
    }

    //FOR ACCESSING GAMEWORLD FUNCTIONS
    public static void setTarget(GameWorld gw){
       // if(game == null)
            game = gw;
    }

    //ACTUALLY PERFORM THE ACTION
    public void actionPerformed(ActionEvent e){
        game.toggleSound();

        if(game.isSoundOn()){
            game.turnOnSound();
        }
        else{
            game.turnOffSound();
        }
    }
}
