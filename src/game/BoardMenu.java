package game;

public class BoardMenu implements IMenu{
    @Override
    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.STANDARD + ". Standard Board\n");
        sb.append(Constants.CUSTOM + ". Custom Board\n");
        sb.append("Please choose an option:\n");
        return sb.toString();
    }

    @Override
    public void printMenu() {
        System.out.println(Constants.STANDARD + ". Standard Board");
        System.out.println(Constants.CUSTOM + ". Custom Board");
        System.out.println("Please choose an option:");
    }
}
