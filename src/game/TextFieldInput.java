package game;

public class TextFieldInput implements Input{

    private String input;
    private int choice;

    public TextFieldInput(){
        input = "";
        choice = -1;
    }

    @Override
    public int getInput(ViewsSubject viewsSubject) {
        choice = -1;
        while (choice == -1) {
            input = "";
            while (input.equals("")) {
                input = GraphicalView.getInput();
                try {
                    choice = Integer.parseInt(input);
                }catch (NumberFormatException e){
                    choice = -1;
                }

            }
        }
        GraphicalView.clearInput();
        return choice;
    }

    @Override
    public void close() {

    }
}
