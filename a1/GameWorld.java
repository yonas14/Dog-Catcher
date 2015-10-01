package a1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yoni on 9/15/15.
 */
public class GameWorld
{

    private int dogPopulation;
    private int catPopulation;
    private ArrayList<Animal> animalsLists;
    private ArrayList<Dog> dogsList;
    private ArrayList<Cat> catsList;
    private ArrayList<Net> netList;
    private int net;
    private int totalPoints;

    Scanner amount;

    public void initLayout()
    {


        dogsList = new ArrayList<>();
        catsList = new ArrayList<>();
        netList = new ArrayList<>();
        System.out.println("Please enter the amount of Dogs");
        amount = new Scanner(System.in);
        dogPopulation = amount.nextInt();

        System.out.println("Please enter the amount of Cats");
        catPopulation = amount.nextInt();
        createDogs();
        createCats();
        for (int i = 0; i < dogsList.size(); i++) {
            System.out.println(dogsList.get(i));

        }
        for (int i = 0; i < catsList.size(); i++) {
            System.out.println(catsList.get(i));

        }


    }
    private void createNets(){

            Net net = new Net();

            net.setColor(Color.GREEN);
            netList.add(net);
    }
    private void createDogs() { // this will add the dog inside the array List
        for(int i = 0; i< dogPopulation; i++) {
            Dog dog = new Dog();
            dog.setSpeed(5);
            dog.setColor(Color.RED);
            dog.randLocation();
            dogsList.add(dog);
        }
    }

    private void createCats() { // this will add the dog inside the array List
        for(int i = 0; i< catPopulation; i++) {
            Cat cat = new Cat();
            cat.setSpeed(5);
            cat.randLocation();
            cat.setColor(Color.BLACK);
            catsList.add(cat);
        }
    }

    public void clockTick()
    {
        for (int i = 0; i < dogPopulation ; i++)
            dogsList.get(i).move();
    }

    public void fight(){

        for (int i = 0; i < dogPopulation ; i++) {
            dogsList.get(i).setSpeed(dogsList.get(i).getSpeed()-1);
        }

    }
    public void makeKitten()
    {
        Cat cat = new Cat();
        cat.setSpeed(5);
        cat.randLocation();
        cat.setColor(Color.BLACK);
        catsList.add(cat);
        catPopulation++;
    }
    public void map(){
        for (int i = 0; i < dogsList.size(); i++) {
            System.out.println(dogsList.get(i));

        }

        for (int i = 0; i < catsList.size(); i++) {
            System.out.println(catsList.get(i));

        }
    }



}
