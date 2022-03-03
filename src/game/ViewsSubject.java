package game;

import game.IObservable;

import java.util.ArrayList;
import java.util.List;

public class ViewsSubject implements IObservable {

    private List<ViewsObserver> listObservers;
    private String state;

    public ViewsSubject(){
        listObservers = new ArrayList<>();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    @Override
    public void attach(ViewsObserver viewsObservers) {
        listObservers.add(viewsObservers);
    }

    @Override
    public void notifyAllObservers() {
        for(ViewsObserver viewsObservers : listObservers){
            viewsObservers.update();
        }
    }

    public ViewsObserver getObserver(int num){
        return listObservers.get(num);
    }
}
