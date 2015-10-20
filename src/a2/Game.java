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

    private NetExpand nets=  new NetExpand();
    private ShrinkNet shrink = new ShrinkNet();
    private ScoopCmd scoopCmd = new ScoopCmd();
    private NetMoveR netMoveR = new NetMoveR();
    private NetMoveL netMoveL = new NetMoveL();
    private NetMoveU netMoveU = new NetMoveU();
    private NetMoveD netMoveD = new NetMoveD();
    private KittenCollison kittenCollison = new KittenCollison();
    private FightCmd fight = new FightCmd();
    private TickCmd tick = new TickCmd();

    private JButton expandNet = new JButton(nets);
    private JButton shrinkNet= new JButton(shrink);
    private JButton scoop = new JButton(scoopCmd);
    private JButton moveRight = new JButton(netMoveR);
    private JButton moveLeft = new JButton(netMoveL);
    private JButton moveUp = new JButton(netMoveU);
    private JButton moveDown = new JButton(netMoveD);
    private JButton kittenCollisonB = new JButton(kittenCollison);
    private JButton fightB = new JButton(fight);
    private JButton tickB = new JButton(tick);



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
        add(top, BorderLayout.NORTH);
        top.add(expandNet);

///////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////The Panel Side bar for the buttons/////////////////////////////////
        left.setBorder(new TitledBorder("Commands: "));   // border of the layout
        left.setLayout(new GridLayout(10, 1));        //attach action listeners

/////////////////////////expand net//////////////////////////////////////////////////////////////
        left.add(expandNet);
        nets.setGameWorld(gw);
        expandNet.setAction(nets);

///////////////////////////shrink net//////////////////////////////////////////////////////////////
        left.add(shrinkNet);
        shrink.setGameWorld(gw);
        shrinkNet.setAction(shrink);

////////////////////////////scoop//////////////////////////////////////////////////////////
        left.add(scoop);
        scoopCmd.setGameWorld(gw);
        scoop.setAction(scoopCmd);

/////////////////////////////move right////////////////////////////////////////////////////////////
        left.add(moveRight);
        netMoveR.setGameWorld(gw);
        moveRight.setAction(netMoveR);

////////////////////////////move left///////////////////////////////////////////////////////////
        left.add(moveLeft);
        netMoveL.setGameWorld(gw);
        moveLeft.setAction(netMoveL);

////////////////////////////move up////////////////////////////////////////////////////////////
        left.add(moveUp);
        netMoveU.setGameWorld(gw);
        moveUp.setAction(netMoveU);

//////////////////////////move down///////////////////////////////////////////////////////////////
        left.add(moveDown);
        netMoveD.setGameWorld(gw);
        moveDown.setAction(netMoveD);

///////////////////////////kitten collison/////////////////////////////////////////////////////////////
        left.add(kittenCollisonB);
        kittenCollison.setGameWorld(gw);
        kittenCollisonB.setAction(kittenCollison);

////////////////////////fight////////////////////////////////////////////////////////////////////
        left.add(fightB);
        fight.setGameWorld(gw);
        fightB.setAction(fight);

///////////////////////tick////////////////////////////////////////////////////////////////////
        left.add(tickB);
        tick.setGameWorld(gw);
        tickB.setAction(tick);

///////////////////////////////////////////////////////////////////////////////////////////////////
        add(left, BorderLayout.WEST); // add the panel holding the buttons
        setVisible(true);
        play();

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
