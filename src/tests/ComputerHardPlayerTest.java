package tests;

import game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerHardPlayerTest {

    ComputerHardPlayer chp = new ComputerHardPlayer();
    ViewsSubject viewsSubject = new ViewsSubject();

    @Test
    void doOperationTest() {
        IBoard board = new Board();
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' '},
                     {' ',' ',' ',' ',' ',' ',' '},
                     {'O',' ',' ',' ',' ',' ',' '}};
        board.setBoard(b1);

        char b2[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '}};

        chp.doOperation(board,viewsSubject);
        chp.draw(board);

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void doOperationTest2() {
        IBoard board = new Board();
        char b1[][] = {{'X',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '}};
        board.setBoard(b1);

        char b2[][] = {{'X',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '},
                {'X','X',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '}};

        chp.doOperation(board,viewsSubject);
        chp.draw(board);

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void doOperationTest3() {
        IBoard board = new Board();
        char b1[][] = {{'X','X',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '},
                {'X','X',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '},
                {'X','X',' ',' ',' ',' ',' '},
                {'O','O','O',' ',' ',' ',' '}};
        board.setBoard(b1);

        char b2[][] = {{'X','X',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '},
                {'X','X',' ',' ',' ',' ',' '},
                {'O','O',' ',' ',' ',' ',' '},
                {'X','X',' ',' ',' ',' ',' '},
                {'O','O','O','X',' ',' ',' '}};

        chp.doOperation(board,viewsSubject);
        chp.draw(board);

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void doOperationTest4() {
        IBoard board = new Board();
        char b1[][] = {{'X','X','X',' ',' ',' ',' '},
                {'O','O','O',' ',' ',' ',' '},
                {'X','X','X',' ',' ',' ',' '},
                {'O','O','O',' ',' ',' ',' '},
                {'X','X','X',' ',' ',' ',' '},
                {'O','O','O','X','O','O',' '}};
        board.setBoard(b1);

        char b2[][] = {{'X','X','X',' ',' ',' ',' '},
                {'O','O','O',' ',' ',' ',' '},
                {'X','X','X',' ',' ',' ',' '},
                {'O','O','O',' ',' ',' ',' '},
                {'X','X','X','X',' ',' ',' '},
                {'O','O','O','X','O','O',' '}};

        chp.doOperation(board,viewsSubject);
        chp.draw(board);

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void doOperationTest5() {
        IBoard board = new Board();
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '}};
        board.setBoard(b1);

        char b2[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'X',' ',' ',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '},
                {'X','O','O',' ',' ',' ',' '}};

        chp.doOperation(board, viewsSubject);
        chp.draw(board);

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void setCol() {
        chp.setCol(3);
        assertEquals(3,chp.getCol());
    }

    @Test
    void setRow() {
        chp.setRow(4);
        assertEquals(4,chp.getRow());
    }

    @Test
    void getDiskColor() {
        chp.setDiskColor(Constants.XPLAYER);
        assertEquals(Constants.XPLAYER,chp.getDiskColor().getColor());
    }

    @Test
    void resetMoves(){
        chp.setCol(8);
        chp.resetMoves();
        assertEquals(-1,chp.getCol());
    }

}