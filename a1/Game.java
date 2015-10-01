package a1;

import java.util.Scanner;

/**
 * Created by yoni on 9/15/15.
 */
public class Game
{
    private GameWorld gw;
    private Scanner scan;
    private Scanner confirm;
    private String quit;

    public Game()
    {

        gw = new GameWorld();
        gw.initLayout();
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
                    System.out.println("Expand the size of the net");
                    break;
                case "c":
                    System.out.println("Contract the size of the net");
                    break;
                case "s":
                    System.out.println("Scoop up all the animals in the net");
                    break;
                case "r":
                    System.out.println("Move the net to the right");
                    break;
                case "i":
                    System.out.println("Move the net to the left");
                    break;
                case "u":
                    System.out.println("Move the net up");
                    break;
                case "d":
                    System.out.println("Move the net down");
                    break;
                case "k":
                    gw.makeKitten();
                    System.out.println("Pretend that a collision occurred between two cats");
                    break;
                case "f": gw.fight();
                    System.out.println("Please enter a command");
                    //System.out.println("Pretend that a fight occurred between a cat and a dog");
                    break;
                case "t":
                    gw.clockTick();
                    System.out.println("Please enter a command");
                   // System.out.print("a1.Game clock has ticked\n");
                    break;
                case "p":
                    System.out.print("Printing Points\n");
                    break;
                case "m": gw.map();
                    //System.out.print("Printing Map\n");
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
                    break;
            }
        }




    }


}
