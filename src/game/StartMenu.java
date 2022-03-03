package game;

public class StartMenu implements IMenu{
    @Override
    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.QUIT + ". Exit\n");
        sb.append(Constants.PLAY + ". Play against a friend\n");
        sb.append(Constants.PLAYCOMPUTER + ". Play against the computer\n");
        sb.append("Please choose an option:\n");
        return sb.toString();
    }

    @Override
    public void printMenu(){
        System.out.println(Constants.QUIT + ". Exit");
        System.out.println(Constants.PLAY + ". Play against a friend");
        System.out.println(Constants.PLAYCOMPUTER + ". Play against the computer");
        System.out.println("Please choose an option:");
    }
}
