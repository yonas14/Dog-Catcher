package A3;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * Created by School on 10/20/15.
 */
public class Sound extends AbstractAction {

    private GameWorld gw;
    public Sound(GameWorld gw){

        super("Sound");
        this.gw =(gw);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(gw.getSoundF()){
           gw.setSoundF(false);
        }else{
            gw.setSoundF(true);
        }
    }
}
