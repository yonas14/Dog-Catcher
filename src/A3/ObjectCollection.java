package A3;


import java.util.Vector;

/**
 * Created by School on 10/18/15.
 */

public class ObjectCollection implements IObjectCollection {

     private Vector theCollection;


     public ObjectCollection(){
        theCollection = new Vector();
     }


    public IIterator getIterator() {
        return new GameObjectIterator();
    }

    @Override
    public void addToCollection(Object object) {
        theCollection.add(object);
    }

    @Override
    public boolean removeFromCollection(int i) {
        theCollection.remove(i);
        return false;
    }

    @Override
    public int size() {
        return theCollection.size();
    }




    public Object get(int i){
          return theCollection.get(i);
      }

    public int getIndex(Object obj){

        for (int i = 0; i < theCollection.size() ; i++) {
            if (theCollection.get(i) == obj){
               return i;
            }
        }

        return 0;
    }

         private class GameObjectIterator implements IIterator{
             private int index;

             public GameObjectIterator(){
                 index = -1;
             }

             public boolean hasNext() {
                 if(theCollection.size() < 1){
                     return false;
                 }
                 if(index == theCollection.size() - 1){
                     return false;
                 }
                return true;
            }

             public Object getNext() {
                 index++;
                 return theCollection.get(index);
             }

             public void remove() {
                 theCollection.remove(index);
             }

             public int getIndex(){
                 return index;
             }

             public Object objectAt(int i){
                 return theCollection.get(i);
             }
         }

}
























































