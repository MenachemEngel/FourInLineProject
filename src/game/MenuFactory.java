package game;

public class MenuFactory {
    public static IMenu getMenu(String menuType){
        if(menuType == null){
            return null;
        }
        if(menuType.equalsIgnoreCase(StartMenu.class.getName())){
            return new StartMenu();
        }else if(menuType.equalsIgnoreCase(BoardMenu.class.getName())){
            return new BoardMenu();
        }else if(menuType.equalsIgnoreCase(LevelMenu.class.getName())){
            return new LevelMenu();
        }
        return null;
    }
}
