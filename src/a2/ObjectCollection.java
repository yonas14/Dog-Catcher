package a2;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by School on 10/18/15.
 */
public class ObjectCollection implements Iterator {

    private Vector theCollection;


    public ObjectCollection(){
       theCollection = new Vector();
    }

    public int size(){
        return theCollection.size();
    }

    public Object get(int i){
        return theCollection.get(i);
    }
    // this add it to collection
    public void addToCollection(Object object){
        theCollection.add(object);
    }

    //removes from collection
    public Object removeFromCollection(int i){
         theCollection.remove(i);
        return null;
    }

    //returns the entire vector
    public Iterator getIterator(){

        return (Iterator)theCollection;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }


}
