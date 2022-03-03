package tests;

import game.Board;
import game.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    Board board = new Board();

    @Test
    void boardIsFull() {
        char b[][] = {{'X','X','X','X','X','X','X'},
                {'O','O','O','O','O','O','O'},
                {'X','X','X','X','X','X','X'},
                {'O','O','O','O','O','O','O'},
                {'X','X','X','X','X','X','X'},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b);
        assertEquals(true, Utilities.boardIsFull(board));
    }
}