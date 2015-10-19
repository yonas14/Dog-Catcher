package a2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/*
 * Created by yoni on 9/15/15.
 */
public class Game extends JFrame implements ActionListener
{
    private GameWorld gw;
    private MapView mapView;
    private ScoreView scoreView;

    private Scanner scan;
    private Scanner confirm;
    private String quit;


    private JPanel top = new JPanel();
    private JPanel left = new JPanel();
    private JPanel map = new JPanel();

    private JButton expandNet = new JButton("Expand Net");
    private JButton shrinkNet= new JButton("Shrink Net");
    private JButton scoop = new JButton("scoop");
    private JButton moveRight = new JButton("Move Right");
    private JButton moveLeft = new JButton("Move Left");
    private JButton moveUp = new JButton("Move Up");
    private JButton moveDown = new JButton("Move Down");
    private JButton kittenCollison = new JButton("Kitten Collision");
    private JButton fight = new JButton("Dog/Cat collsion");
    private JButton tick = new JButton("Tick");

    public Game()
    {
        gw = new GameWorld();
        mapView = new MapView();
        scoreView= new ScoreView();
        gw.initLayout();
        gw.addObserver(mapView);
        gw.addObserver(scoreView);


        setTitle("Yonas");
        setSize(1024, 1024);
        setResizable(false);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

/////////////////The Panel on top for the points//////////////////////////////////
        top.setBorder(new LineBorder(Color.red, 2));   //Border of the layout
        top.add(tick);
        add(top, BorderLayout.NORTH);

///////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////The Panel Side bar for the buttons/////////////////////////////////
        left.setBorder(new TitledBorder("Commands: "));   // border of the layout
        left.setLayout(new GridLayout(10, 1));        //attach action listeners

        left.add(expandNet);

        left.add(shrinkNet);
        left.add(scoop);
        left.add(moveRight);
        left.add(moveLeft);
        left.add(moveUp);
        left.add(moveDown);
        left.add(kittenCollison);
        left.add(fight);
        left.add(tick);

        add(left, BorderLayout.WEST);
///////////////////////////////////////////////////////////////////////////////////////////////////





        setVisible(true);

       // play();

    }

    private void play()
    {
        getCommand();

    }

    private void getCommand(){

        System.out.println("Please Enter Command");


        scan = new Scanner(System.in);
        confirm = new Scanner(System.in);
        String command  = "";
        while(command != "q")
        {
            command = scan.nextLine();
            switch (command) {

                case "e":
                    gw.expand();
                    System.out.println("Expand the size of the net");
                    System.out.println("Please Enter Command");

                    break;
                case "c":
                    gw.contract();
                    System.out.println("Contract the size of the net");
                    System.out.println("Please Enter Command");

                    break;
                case "s":
                    gw.scoop();
                    System.out.println("Scoop up all the animals in the net");
                    System.out.println("Please Enter Command");
                    break;
                case "r":
                    gw.right();
                    System.out.println("Move the net to the right");
                    System.out.println("Please Enter Command");

                    break;
                case "l":
                    gw.left();
                    System.out.println("Move the net to the left");
                    System.out.println("Please Enter Command");

                    break;
                case "u":
                    gw.up();
                    System.out.println("Move the net up");
                    System.out.println("Please Enter Command");

                    break;
                case "d":
                    gw.down();
                    System.out.println("Move the net down");
                    System.out.println("Please Enter Command");

                    break;
                case "k":
                    gw.makeKitten();
                    System.out.println("Pretend that a collision occurred between two cats");
                    System.out.println("Please Enter Command");

                    break;
                case "f": gw.fight();
                    System.out.println("Pretend that a fight occurred between a cat and a dog");
                    System.out.println("Please enter a command");

                    break;
                case "t":
                    gw.clockTick();
                    System.out.print("a1.Game clock has ticked\n");
                    System.out.println("Please enter a command");
                    break;
                case "p":
                    gw.print();
                    System.out.print("Printing Points\n");
                    System.out.println("Please enter a command");
                    break;
                case "m": gw.map();
                    System.out.print("Printing Map\n");
                    System.out.println("Please enter a command");
                    break;
                case "q":
                    System.out.println("Are you sure you want to quite y/n");
                    quit = confirm.next();

                    if (quit.equals("n")) {
                        System.out.println("Please enter your command");
                        break;
                    } else {
                        System.exit(0);
                        break;
                    }

                default:
                    System.out.println("Invalid entry Son");
                    System.out.println("Please Enter a valid commandscS");
                    break;
            }
        }




    }


    @Override
    public void actionPerformed(ActionEvent e) {

            gw.expand();

    }
}
