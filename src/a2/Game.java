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
    private JPanel center = new JPanel();

    private NetExpand nets=  new NetExpand();
    private ShrinkNet shrink = new ShrinkNet();
    private ScoopCmd scoopCmd = new ScoopCmd();
    private NetMoveR netMoveR = new NetMoveR();
    private NetMoveL netMoveL = new NetMoveL();
    private NetMoveU netMoveU = new NetMoveU();
    private NetMoveD netMoveD = new NetMoveD();
    private KittenCollision kittenCollision = new KittenCollision();
    private FightCmd fight = new FightCmd();
    private TickCmd tick = new TickCmd();
    private Quit quitCmd = new Quit();
    private Sound soundCmd;
    private About aboutCmd;


    private JButton expandNet = new JButton(nets);
    private JButton shrinkNet= new JButton(shrink);
    private JButton scoop = new JButton(scoopCmd);
    private JButton moveRight = new JButton(netMoveR);
    private JButton moveLeft = new JButton(netMoveL);
    private JButton moveUp = new JButton(netMoveU);
    private JButton moveDown = new JButton(netMoveD);
    private JButton kittenCollisonB = new JButton(kittenCollision);
    private JButton fightB = new JButton(fight);
    private JButton tickB = new JButton(tick);




    public Game()
    {
        gw = new GameWorld();
        mapView = new MapView(gw);
        scoreView= new ScoreView(gw);

        gw.initLayout();

        int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap imap = left.getInputMap(mapName);
        ActionMap amap = left.getActionMap();



        setTitle("Yonas");
        setSize(1024, 1024);
        setResizable(false);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



/////////////////The Panel on top for the points//////////////////////////////////
        top.setBorder(new LineBorder(Color.red, 2));   //Border of the layout
        top.setLayout(new GridLayout(1,7));
        add(top, BorderLayout.NORTH);
        top.add(scoreView);


///////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////The Panel Side bar for the buttons/////////////////////////////////
        left.setBorder(new TitledBorder("Commands: "));   // border of the layout
        left.setLayout(new GridLayout(10, 1));        //attach action listeners

/////////////////////////expand net//////////////////////////////////////////////////////////////
        left.add(expandNet);
        nets.setGameWorld(gw);
        expandNet.setAction(nets);
        imap.put(KeyStroke.getKeyStroke('e'),"Expand"); //direction and scoop
        amap.put("Expand", nets);


///////////////////////////shrink net//////////////////////////////////////////////////////////////
        left.add(shrinkNet);
        shrink.setGameWorld(gw);
        shrinkNet.setAction(shrink);
        amap.put("Shrink", shrink);


////////////////////////////scoop//////////////////////////////////////////////////////////
        left.add(scoop);
        scoopCmd.setGameWorld(gw);
        scoop.setAction(scoopCmd);
        imap.put(KeyStroke.getKeyStroke('s'),"Scoop"); //direction and scoop
        amap.put("Scoop",scoopCmd);


/////////////////////////////move right////////////////////////////////////////////////////////////
        left.add(moveRight);
        netMoveR.setGameWorld(gw);
        moveRight.setAction(netMoveR);
        imap.put(KeyStroke.getKeyStroke('r'),"Move Right"); //direction and scoop
        amap.put("Move", netMoveR);
        amap.put("Move Right", netMoveR);
////////////////////////////move left///////////////////////////////////////////////////////////
        left.add(moveLeft);
        netMoveL.setGameWorld(gw);
        moveLeft.setAction(netMoveL);

        imap.put(KeyStroke.getKeyStroke('l'),"Move Left"); //direction and scoop
        amap.put("Move Left", netMoveL);
////////////////////////////move up////////////////////////////////////////////////////////////
        left.add(moveUp);
        netMoveU.setGameWorld(gw);
        moveUp.setAction(netMoveU);
        imap.put(KeyStroke.getKeyStroke('u'),"Move Up"); //direction and scoop
        amap.put("Move Up", netMoveU);


//////////////////////////move down///////////////////////////////////////////////////////////////
        left.add(moveDown);
        netMoveD.setGameWorld(gw);
        moveDown.setAction(netMoveD);
        imap.put(KeyStroke.getKeyStroke('d'),"Move Down"); //direction and scoop
        amap.put("Move Down", netMoveD);


///////////////////////////kitten collison/////////////////////////////////////////////////////////////
        left.add(kittenCollisonB);
        kittenCollision.setGameWorld(gw);
        kittenCollisonB.setAction(kittenCollision);
        imap.put(KeyStroke.getKeyStroke('k'),"Collision"); //direction and scoop
        amap.put("Collision", kittenCollision);


////////////////////////fight////////////////////////////////////////////////////////////////////
        left.add(fightB);
        fight.setGameWorld(gw);
        fightB.setAction(fight);
        imap.put(KeyStroke.getKeyStroke('f'),"Fight"); //direction and scoop
        amap.put("Fight", fight);


///////////////////////tick////////////////////////////////////////////////////////////////////
        left.add(tickB);
        tick.setGameWorld(gw);
        tickB.setAction(tick);
        imap.put(KeyStroke.getKeyStroke('t'),"Tick"); //direction and scoop
        amap.put("Tick", tick);
        add(left, BorderLayout.WEST); // add the panel holding the buttons

 ///////////////////////QUIT////////////////////////////////////////////////////////////////////
        imap.put(KeyStroke.getKeyStroke('q'), "Quit");
        amap.put("Quit", quitCmd);


///////////////////////////////////////////////////////////////////////////////////////////////////

        center.setBorder(new LineBorder(Color.red, 2));   //Border of the layout
        center.setLayout(new GridLayout(1,7));
        add(center, BorderLayout.CENTER);
        center.add(mapView);










        JMenuBar menus = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mFNewGame = new JMenuItem("New");
        mFile.add(mFNewGame);
        JMenuItem mFSaveGame = new JMenuItem("Save");
        mFile.add(mFSaveGame);
        JMenuItem mFUndoGame = new JMenuItem("Undo");
        mFile.add(mFUndoGame);



        JMenuItem mFSoundGame = new JCheckBoxMenuItem("Sound");
        soundCmd = new Sound(gw);
        gw.setSoundF(true);
        mFSoundGame.setAction(soundCmd);
        mFSoundGame.setSelected(true);
        mFile.add(mFSoundGame);








        JMenuItem mFAboutGame = new JMenuItem("About");
        aboutCmd = new About();
        mFAboutGame.setAction(aboutCmd);
        mFile.add(mFAboutGame);
        JMenuItem mFQuitGame = new JMenuItem("Quit");
        quitCmd = new Quit();
        mFQuitGame.setAction(quitCmd);
        mFile.add(mFQuitGame);

        menus.add(mFile);

        JMenu mCommands = new JMenu("Commands");
        JMenuItem mCEx = new JMenuItem("Expand Net");
        mCEx.setAction(nets);
        mCommands.add(mCEx);
        JMenuItem mCShrink = new JMenuItem("Shrink Net");
        mCShrink.setAction(shrink);
        mCommands.add(mCShrink);
        JMenuItem mCCollision = new JMenuItem("Collision/Kitten");
        mCCollision.setAction(kittenCollision);
        mCommands.add(mCCollision);
        JMenuItem mCFight = new JMenuItem("Fight");
        mCFight.setAction(fight);
        mCommands.add(mCFight);
        JMenuItem mCQuit = new JMenuItem("Quit");
        mCQuit.setAction(quitCmd);
        mCommands.add(mCQuit);

        menus.add(mCommands);
        this.setJMenuBar(menus);









        setVisible(true);
        play();
        gw.setTotalPoints(0);

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
