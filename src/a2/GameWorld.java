package a2;

import javax.xml.bind.ValidationException;
import java.awt.*;
import java.util.*;
import java.util.Iterator;

/**
 * Created by yoni on 9/15/15.
 */
public class GameWorld
{
    private Net net;
    private int dogPopulation,catPopulation;
    private int scratch; //used to randomly pick a dog to scratch
    private Random randDirection;
    private Random randScratch;
    private ObjectCollection gameObjList;
    private int totalPoints;
    private Scanner amount;
    private int tick;
    private int dogCaught;
    private int catCaught;
    private float netXtopRight;
    private float netYtopLeft;
    private float netYbottomRight;
    private float netbottomLeft;
    private int score;
    private int scratches;

    private ArrayList<IObserver> observer;



    public void initLayout()
    {

        gameObjList = new ObjectCollection();
        randDirection = new Random();
        System.out.println("Please enter the amount of Dogs");
        amount = new Scanner(System.in);
        dogPopulation = amount.nextInt();

        System.out.println("Please enter the amount of Cats");
        catPopulation = amount.nextInt();
        createNets();
        createDogs();
        createCats();
        for (int i = 0; i < gameObjList.size(); i++) {
            System.out.println(gameObjList.get(i));
        }
    }


    public void addObserver (IObserver obs){
        observer = new ArrayList<IObserver>();
        observer.add(obs);

    }



    public void notifyObservers(){



    }

    public int getSize(){

        return gameObjList.size();
    }



    private void createNets(){

            net = new Net();
            net.setColor(Color.GREEN);
            net.setSize(100);
            net.randLocation();
            gameObjList.addToCollection(net);
    }
    private void createDogs() { // this will add the dog inside the array List
        for(int i = 0; i< dogPopulation; i++) {
            Dog dog = new Dog();

            dog.setSpeed(5);
            dog.setColor(Color.RED);
            dog.randLocation();
            dog.setDirection(randDirection.nextInt(360));
            gameObjList.addToCollection(dog);
        }
    }

    private void createCats() { // this will add the dog inside the array List
        for(int i = 0; i< catPopulation; i++) {
            Cat cat = new Cat();

            cat.setSpeed(5);
            cat.randLocation();
            cat.setColor(Color.BLACK);
            cat.setDirection(randDirection.nextInt(360));
            gameObjList.addToCollection(cat);

        }
    }

    public void expand(){
        for (int i = 0; i < gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net){
                ((Net)gameObjList.get(i)).expand();


            }
        }

    }

    public void contract(){
        for (int i = 0; i < gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net){
                ((Net)gameObjList.get(i)).contract();


            }
        }

    }

    public void scoop(){

        netXtopRight  = net.getLocationX() - (net.getSize()/2);
        netYtopLeft = net.getLocationX() + (net.getSize()/2);
        netYbottomRight= net.getLocationY() - (net.getSize()/2);
        netbottomLeft   = net.getLocationY() + (net.getSize()/2);

        for (int i = 0; i < gameObjList.size() ; i++) {
            if(gameObjList.get(i) instanceof Dog){
                if ((((Dog) gameObjList.get(i)).getLocationX() > netXtopRight) && (((Dog) gameObjList.get(i)).getLocationX() < netYtopLeft) &&
                        (((Dog) gameObjList.get(i)).getLocationY() > netYbottomRight) && (((Dog) gameObjList.get(i)).getLocationY() < netbottomLeft)) {
                     dogCaught++;
                    dogPopulation--;
                    System.out.println("Dog Caught");
                    gameObjList.removeFromCollection(i);
                    if (dogPopulation == 0) {
                        System.out.print("Game Over Son");

                    }
                }
            }


        }
        for (int i = 0; i < gameObjList.size() ; i++) {
            if(gameObjList.get(i) instanceof Cat){
                if((((Cat) gameObjList.get(i)).getLocationX() > netXtopRight) && (((Cat) gameObjList.get(i)).getLocationX() < netYtopLeft) &&
                        (((Cat) gameObjList.get(i)).getLocationY() > netYbottomRight) && (((Cat) gameObjList.get(i)).getLocationY() < netbottomLeft)){
                    catCaught++;
                    catPopulation--;
                    System.out.println("Cat Caught");

                    gameObjList.removeFromCollection(i);

                }
            }

        }

    }

    public void print(){

        if (dogCaught < catCaught){
                totalPoints = (dogCaught-catCaught)*10;
        }
        if (catCaught < dogCaught){
                totalPoints = (dogCaught-catCaught)*10;
        }
        if (scratches > 0){
            for (int i = 0; i < scratches; i++) {
                totalPoints = totalPoints - 1;

            }
        }

        System.out.println  ("Score = "+totalPoints+
                            " Number of cats= "+catPopulation+
                            " Number of dogs= "+dogPopulation+
                            "Number of dogs caught " + dogCaught+
                            "Number of cats scooped " + catCaught+
                            " Total amount scratches "+ scratches );

    }



    public void right(){
        for (int i = 0; i <gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net) {
                ((Net)gameObjList.get(i)).moveRight();
            }

        }
    }

    public void left(){
        for (int i = 0; i <gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net) {
                ((Net)gameObjList.get(i)).moveLeft();
            }

        }

    }
    public void up(){
        for (int i = 0; i <gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net) {
                ((Net)gameObjList.get(i)).moveUp();
            }

        }
    }
    public void down(){
        for (int i = 0; i <gameObjList.size() ; i++) {
            if (gameObjList.get(i) instanceof Net) {
                ((Net)gameObjList.get(i)).moveDown();
            }

        }
    }


    public void clockTick() {
        tick++;
        for (int i = 0; i < gameObjList.size() ; i++) {
            if(gameObjList.get(i)instanceof Animal){
                ((Animal) gameObjList.get(i)).move();
            }
        }

    }




    public void fight(){
        randScratch = new Random();
        scratch = randScratch.nextInt(dogPopulation);

        for (int i = scratch; i <= dogPopulation ; i++) {
            if (gameObjList.get(i)instanceof Dog && ((Dog) gameObjList.get(i)).getSpeed() != 0) {
                ((Dog)gameObjList.get(i)).setSpeed(((Dog)gameObjList.get(i)).getSpeed() - 1);
                ((Dog) gameObjList.get(i)).setScratches(((Dog)gameObjList.get(i)).getScratches() + 1);
                ((Dog)gameObjList.get(i)).setRandomColor();
                break;
            }

        }

        scratches++;
    }

    public void makeKitten() {
        if (catPopulation <= 1){
            System.out.println("you at least need two cats to make a kitten");

        }else {
            Cat cat = new Cat();
            cat.setSpeed(5);
            cat.randLocation();
            cat.setColor(Color.BLACK);
            cat.setDirection(randDirection.nextInt(360));
            gameObjList.addToCollection(cat);
            catPopulation++;
        }
    }

    public void map(){
        for (int i = 0; i < gameObjList.size(); i++) {
            System.out.println(gameObjList.get(i));
        }

    }



}
