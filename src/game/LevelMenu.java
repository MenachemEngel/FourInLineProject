package game;

public class LevelMenu implements IMenu{
    @Override
    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.EASY + ". Easy\n");
        sb.append(Constants.HARD + ". Hard\n");
        sb.append("Please choose an option:\n");
        return sb.toString();
    }

    @Override
    public void printMenu() {
        System.out.println(Constants.EASY + ". Easy");
        System.out.println(Constants.HARD + ". Hard");
        System.out.println("Please choose an option:");
    }
}
