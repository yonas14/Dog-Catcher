package a4;

/**
 * Created by School on 11/17/15.
 */
public interface IObservable {
    void addObserver (IObserver obs);
    void notifyObservers();

}
