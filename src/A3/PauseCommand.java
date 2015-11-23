package A3;

/**
 * Created by School on 11/18/15.
 */

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
public class PauseCommand  extends AbstractAction{

    private static PauseCommand pauseCommand;
    private static Game game;

    public PauseCommand(){
        super("Pause");
    }


    public static PauseCommand getInstance(){
        if(pauseCommand == null)
            pauseCommand = new PauseCommand();
        return pauseCommand;
    }

    public static void setTarget(Game g){
        if(game == null)
            game = g;
    }


    public void actionPerformed(ActionEvent e){
        if(game.isPaused()){
            game.resumeGame();
        }
        else if(!game.isPaused()){
            game.pauseGame();
        }
    }
}
