package tests;

import game.Constants;
import game.LevelMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelMenuTest {

    LevelMenu levelMenu = new LevelMenu();

    @Test
    void getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.EASY + ". Easy\n");
        sb.append(Constants.HARD + ". Hard\n");
        sb.append("Please choose an option:\n");
        levelMenu.printMenu();
        assertEquals(sb.toString(), levelMenu.getMenu());

    }
}