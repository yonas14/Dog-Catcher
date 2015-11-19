package A3;

/**
 * Created by School on 11/15/15.
 */
public interface IIterator {

        public boolean hasNext();
        public Object getNext();
        public void remove();

        public int getIndex();
        public Object objectAt(int i);
}
