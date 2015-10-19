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


}
