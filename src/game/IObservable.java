package game;

public interface IObservable {
    public void attach(ViewsObserver viewsObservers);
    public void notifyAllObservers();
}
