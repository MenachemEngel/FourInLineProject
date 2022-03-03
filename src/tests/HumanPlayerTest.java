package tests;

import game.Board;
import game.Constants;
import game.HumanPlayer;
import game.IBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    HumanPlayer hp = new HumanPlayer();
    @Test
    void drawTest() {
        IBoard board = new Board();
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '}};
        board.setBoard(b1);

        char b2[][] = {{'O',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '}};

        hp.setCol(0);
        hp.setRow(0);
        hp.draw(board);
    }

    @Test
    void setColTest(){
        hp.setCol(0);
        assertEquals(0, hp.getCol());
    }

    @Test
    void setRowTest(){
        hp.setRow(0);
        assertEquals(0, hp.getRow());
    }

    @Test
    void getDiskColor() {
        hp.setDiskColor(Constants.XPLAYER);
        assertEquals(Constants.XPLAYER,hp.getDiskColor().getColor());
    }

    @Test
    void resetMoves(){
        hp.setCol(8);
        hp.resetMoves();
        assertEquals(-1,hp.getCol());
    }

}