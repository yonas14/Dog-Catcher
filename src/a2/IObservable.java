package a2;

/**
 * Created by School on 10/17/15.
 */
public interface IObservable {

    public void addObserver (IObserver obs);
    public void notifyObservers();
}
