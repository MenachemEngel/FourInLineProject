package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalInput implements Input{

    private Scanner scanner;
    private int choice;

    public TerminalInput(){
        scanner = new Scanner(System.in);
    }

    @Override
    public int getInput(ViewsSubject viewsSubject) {
        choice = -1;
        while(choice == -1) {
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                viewsSubject.setState("You need to choose number.");
                scanner.nextLine();
                choice = -1;
            }
        }
        return choice;
    }

    @Override
    public void close(){
        scanner.close();
    }
}
