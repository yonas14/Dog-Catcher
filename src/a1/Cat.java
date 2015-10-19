package a1;

/**
 * Created by yoni on 9/15/15.
 */
public class Cat extends Animal{

    @Override
    public String toString() {
        return ("a1.Cat: loc="+getLocationX()+","+getLocationY()+" Color= "+getColor()+" Size="+ getSize()+" Speed= "+getSpeed()+ " dir="+getDirection() );

    }
}
