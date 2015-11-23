package A3;

import java.awt.*;
import java.util.*;

/**
 * Created by yoni on 9/15/15.
 */
public class GameWorld implements IObservable
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
    private Collection start;
    private ArrayList<Object> observerArray = new ArrayList<>();

    public ObjectCollection getGameObjList() {
        return gameObjList;
    }

    public void setGameObjList(ObjectCollection gameObjList) {
        this.gameObjList = gameObjList;
    }

    private float netbottomLeft;




    private int score;
    private int scratches;
    private String onOff;


    private Boolean soundF;




    public void initLayout()
    {




        gameObjList = new ObjectCollection();
        randDirection = new Random();
        System.out.println("Please enter the amount of Dogs");
        amount = new Scanner(System.in);
        setDogPopulation(amount.nextInt());
        System.out.println("Please enter the amount of Cats");
        setCatPopulation(amount.nextInt());
        createNets();
        createDogs();
        createCats();
        for (int i = 0; i < gameObjList.size(); i++) {
            System.out.println(gameObjList.get(i));

        }
    }











    private void createNets(){

            net = new Net();
            net.setColor(Color.GREEN);
            net.setSize(100);
            net.randLocation();
            gameObjList.addToCollection(net);
    }
    private void createDogs() { // this will add the dog inside the array List
        for(int i = 0; i< getDogPopulation(); i++) {
            Dog dog = new Dog();

            dog.setSpeed(5);
            dog.setColor(Color.RED);
            dog.setSize(50);
           // dog.setLocation(0+(dog.getSize()/2),0);
            dog.randLocation();
            dog.setDirection(randDirection.nextInt(360));
            gameObjList.addToCollection(dog);
        }
    }

    private void createCats() { // this will add the dog inside the array List
        for(int i = 0; i< getCatPopulation(); i++) {
            Cat cat = new Cat();

            cat.setSpeed(5);
            cat.randLocation();
            cat.setSize(100);
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
                     setDogCaught(getDogCaught()+1);
                    setDogPopulation((getDogPopulation())-1);

                    System.out.println("Dog Caught");
                    gameObjList.removeFromCollection(i);

                    if (getDogPopulation() == 0) {
                        System.out.print("Game Over Son");

                    }
                }
            }


        }
        System.out.println(getDogPopulation());
        for (int i = 0; i < gameObjList.size() ; i++) {
            if(gameObjList.get(i) instanceof Cat){
                if((((Cat) gameObjList.get(i)).getLocationX() > netXtopRight) && (((Cat) gameObjList.get(i)).getLocationX() < netYtopLeft) &&
                        (((Cat) gameObjList.get(i)).getLocationY() > netYbottomRight) && (((Cat) gameObjList.get(i)).getLocationY() < netbottomLeft)){
                   setCatCaught(getCatCaught()+1);
                   setCatPopulation(getCatPopulation()-1);
                    System.out.println("Cat Caught");

                    gameObjList.removeFromCollection(i);

                }
            }

        }

        print();


    }

    public void print(){

        if (  getDogCaught() < getCatCaught()){
            setTotalPoints((getDogCaught()-getCatCaught())*10);
                //totalPoints =(dogCaught-catCaught)*10 ;
        }
        if (getCatCaught() < getDogCaught()){
            setTotalPoints((getDogCaught()-getCatCaught())*10);
               // totalPoints = (dogCaught-catCaught)*10;
        }
        if (scratches > 0){
            for (int i = 0; i < scratches; i++) {
                //TotalPoints = totalPoints - 1;
                setTotalPoints(getTotalPoints() - 1);

            }
        }


        System.out.println  ("Score = "+totalPoints+
                            " Number of cats= "+catPopulation+
                            " Number of dogs= "+dogPopulation+
                            "Number of dogs caught " + dogCaught+
                            "Number of cats scooped " + catCaught+
                            " Total amount scratches "+ scratches );

    }
    public int getDogCaught() {
        return dogCaught;
    }

    public void setDogCaught(int dogCaught) {
        this.dogCaught = dogCaught;
        notifyObservers();
    }

    public int getCatCaught() {
        return catCaught;
    }

    public void setCatCaught(int catCaught) {
        this.catCaught = catCaught;
        notifyObservers();
    }

    public int getCatPopulation() {
        return catPopulation;
    }

    public void setCatPopulation(int catPopulation) {
        this.catPopulation = catPopulation;
        notifyObservers();
    }

    public int getDogPopulation() {
        return dogPopulation;
    }

    public void setDogPopulation(int dogPopulation) {
        this.dogPopulation = dogPopulation;
        notifyObservers();
    }
    public int getTotalPoints() {
        return totalPoints;

    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
        notifyObservers();
    }

    public Boolean getSoundF() {
        return soundF;

    }

    public void setSoundF(Boolean soundF) {
        this.soundF = soundF;
        notifyObservers();


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


    public void clockTick(int width, int height) {
        tick++;
        IIterator itr = gameObjList.getIterator();
        while(itr.hasNext()){
            Object obj = itr.getNext();
            if(obj instanceof Animal){
               // System.out.println("I am here yonas");
               ((Animal) obj).move();
            }

        }
        notifyObservers();
    }




    public void fight(){
        randScratch = new Random();
        scratch = randScratch.nextInt(getDogPopulation());


        for (int i = scratch; i <= getDogPopulation() ; i++) {
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
        if (getCatPopulation() <= 1){
            System.out.println("you at least need two cats to make a kitten");

        }else {
            Cat cat = new Cat();
            cat.setSpeed(5);
            cat.randLocation();
            cat.setSize(100);
            cat.setColor(Color.BLACK);
            cat.setDirection(randDirection.nextInt(360));
            gameObjList.addToCollection(cat);
            setCatPopulation(getCatPopulation()+1);
        }
    }

    public void map() {
        IIterator iterator = gameObjList.getIterator();
        Object curObj;
        while (iterator.hasNext()) {
            curObj = iterator.getNext();
            System.out.println(curObj.toString());
        }
    }

    public void setStart(Collection start){
        this.start = start;
    }

    public Collection getStart(){
        return start;
    }


    @Override
    public void addObserver(IObserver obs) {
        observerArray.add(obs);
    }

    @Override
    public void notifyObservers() {
        if(!observerArray.isEmpty()){
            for(int i = 0; i < observerArray.size(); i++){
                ((IObserver) observerArray.get(i)).update(this);
            }
        }

    }

    public void healDogs() {
        IIterator iterator = gameObjList.getIterator();
        Object curObj = new Object();

        //ONLY HEAL SELECTED DOGS
        while(iterator.hasNext()){
            curObj = iterator.getNext();
            if(curObj instanceof Dog && ((Dog)curObj).isSelected()){
                ((Dog) curObj).setSelected(false);
                ((Dog) curObj).resetScratches();
                ((Dog) curObj).setSpeed(5);
                ((Dog) curObj).setColor(Color.BLUE);
                notifyObservers();
            }
        }
    }

}
