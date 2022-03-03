package tests;

import game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OffersBoardTest {

    OffersBoard board = new OffersBoard(new Board());

    @Test
    void isEmptyTest() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b1);
        Assertions.assertEquals(true, board.isEmpty(4,0));
    }

    @Test
    void setBoardTest() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b1);
        Assertions.assertArrayEquals(b1, board.getBoard());
    }

    @Test
    void clearSquareTest() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b1);
        char b2[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O',' ','O','X','O'}};
        board.clearSquare(5,3);
        Assertions.assertArrayEquals(b2, board.getBoard());
    }

    @Test
    void setDiskTest() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O',' ','O','X','O'}};
        board.setBoard(b1);
        char b2[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setDisk(new Disk(Constants.XPLAYER, 5,3));
        Assertions.assertArrayEquals(b2, board.getBoard());
    }

    @Test
    void setBorderTest() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O',' ','O','X','O'}};
        board.setBoard(b1);
        board.setBorder(10, 20);
        assertEquals(10, board.getBoard().length);
        assertEquals(20, board.getBoard()[0].length);
    }

    @Test
    void getBackgroundTest() {
        board.setBackground("red");
        assertEquals("red", board.getBackground());
    }

    @Test
    void isEmptyTest2() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b1);
        board.printBoard();
        Assertions.assertEquals(false, board.isEmpty(5,0));
    }

    @Test
    void getSquare() {
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O','X','O','X','O','X','O'}};
        board.setBoard(b1);
        assertEquals(' ' ,board.getSquare(0, 0));
    }

    /**
     * @Override
     *     public boolean isAllEmpty() {
     *         return decoratorBoard.isAllEmpty();
     *     }
     *
     *     @Override
     *     public String toString() {
     *         return "Background Color " + background + "\n" + decoratorBoard.toString();
     *     }
     */

    @Test
    void isAllEmpty(){
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '}};
        board.setBoard(b1);
        Assertions.assertEquals(true, board.isAllEmpty());
    }

    @Test
    void isAllEmpty2(){
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '}};
        board.setBoard(b1);
        Assertions.assertEquals(false, board.isAllEmpty());
    }

    @Test
    void toStringTest(){
        char b1[][] = {{' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' '},
                {'O',' ',' ',' ',' ',' ',' '}};
        board.setBoard(b1);
        StringBuilder sb = new StringBuilder();
        sb.append("Background Color " + board.getBackground() + "\n");
        for(int i=0;i<b1.length;i++){
            sb.append("|");
            for(int j=0;j<b1[i].length;j++){
                sb.append(b1[i][j]+ "|");
            }
            sb.append("\n");
        }
        assertEquals(sb.toString(), board.toString());
    }
}