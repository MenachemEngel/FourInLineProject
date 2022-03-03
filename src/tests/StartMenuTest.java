package tests;

import game.Constants;
import game.StartMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartMenuTest {

    StartMenu startMenu = new StartMenu();

    @Test
    void getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.QUIT + ". Exit\n");
        sb.append(Constants.PLAY + ". Play against a friend\n");
        sb.append(Constants.PLAYCOMPUTER + ". Play against the computer\n");
        sb.append("Please choose an option:\n");
        startMenu.printMenu();
        assertEquals(sb.toString(), startMenu.getMenu());
    }
}