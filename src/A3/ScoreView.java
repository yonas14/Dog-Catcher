package A3;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by School on 10/17/15.
 */

//ScoreView class containing code to output the current score and other state information
public class ScoreView extends JPanel implements IObserver {

    private JLabel points;
    private JLabel dogCaught;
    private JLabel catCaught;
    private JLabel dogLeft;
    private JLabel catLeft;
    private JLabel sound;

    ScoreView(){

        setLayout(new GridLayout(1,10));

        points = new JLabel("Points  ");
        add(points);
        dogCaught = new JLabel("Dog Arrested  ");
        add(dogCaught);
        catCaught = new JLabel("Cat Arrested  ");
        add(catCaught);
        dogLeft = new JLabel("Dog Pop  ");
        add(dogLeft);
        catLeft = new JLabel("Cat Pop  ");
        add(catLeft);
        sound = new JLabel("Sound  ");
        add(sound);

        this.setVisible(true);

    }


    @Override
    public void update(IObservable o) {
        GameWorld gw = (GameWorld)o;
        points.setText("Points "+ gw.getTotalPoints());
        dogLeft.setText("Dog Pop " + gw.getDogPopulation());
        catLeft.setText("Cat Pop "+ gw.getCatPopulation());
        dogCaught.setText("Dog Arrested " + gw.getDogCaught());
        catCaught.setText("Cat Arrested " + gw.getCatCaught());
        sound.setText("Sounds: " + gw.getSoundF());

    }
}
