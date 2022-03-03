package tests;

import game.BoardMenu;
import game.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardMenuTest {

    BoardMenu boardMenu = new BoardMenu();

    @Test
    void getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.STANDARD + ". Standard Board\n");
        sb.append(Constants.CUSTOM + ". Custom Board\n");
        sb.append("Please choose an option:\n");
        boardMenu.printMenu();
        assertEquals(sb.toString(), boardMenu.getMenu());
    }
}