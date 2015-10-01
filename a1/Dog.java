package a1;

/**
 * Created by yoni on 9/15/15.
 */
public class Dog extends Animal {


    private int scratches;



    public int getScratches()
    {
        return scratches;
    }

    public void setScratches(int scratches)
    {
        this.scratches = scratches;
    }


    @Override
    public String toString() {
        return ("a1.Dog: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection()+ "scratches="+ getScratches() );

    }
}
