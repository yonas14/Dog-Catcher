package a2;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by School on 10/20/15.
 */
public class Quit extends AbstractAction {


    public Quit(){
        super("Quit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("QUITTING GAME");

        int quit = JOptionPane.showConfirmDialog(null, "Do you really want to quit?",
                "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(quit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
}
