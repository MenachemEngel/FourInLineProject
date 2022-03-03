package game;

public abstract class ViewsObserver {
    protected ViewsSubject viewsSubject;
    public abstract void update();
}
