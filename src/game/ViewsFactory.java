package game;

public class ViewsFactory {
    public ViewsObserver getView(String viewType, ViewsSubject viewsSubject){
        if(viewType == null){
            return null;
        }
        if(viewType.equalsIgnoreCase(TextualView.class.getName())){
            return new TextualView(viewsSubject);
        }else if(viewType.equalsIgnoreCase(GraphicalView.class.getName())){
            return new GraphicalView(viewsSubject);
        }
        return null;
    }
}
