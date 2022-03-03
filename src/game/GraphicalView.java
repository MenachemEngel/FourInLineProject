package game;

public class GraphicalView extends ViewsObserver {

    public GraphicalView(ViewsSubject viewsSubject){
        this.viewsSubject = viewsSubject;
        viewsSubject.attach(this);
    }

    @Override
    public void update() {
        //TODO: (for future) Graphical window using java awt
    }
}
