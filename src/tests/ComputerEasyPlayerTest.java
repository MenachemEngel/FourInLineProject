package tests;

import game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerEasyPlayerTest {

    ComputerEasyPlayer cep = new ComputerEasyPlayer();
    ViewsSubject viewsSubject = new ViewsSubject();

    @Test
    void doOperation() {
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
                {' ',' ',' ',' ',' ',' ',' '},
                {'O',' ','X',' ',' ',' ',' '}};

        while(true) {
            System.out.println(cep.getCol());
            cep.doOperation(board, viewsSubject);
            if(cep.getCol() == 2){
                break;
            }
            cep.setCol(-1);
        }
        cep.draw(board);
        board.printBoard();

        Assertions.assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void setCol() {
        cep.setCol(3);
        assertEquals(3,cep.getCol());
    }

    @Test
    void setRow() {
        cep.setRow(4);
        assertEquals(4,cep.getRow());
    }

    @Test
    void getDiskColor() {
        cep.setDiskColor(Constants.XPLAYER);
        assertEquals(Constants.XPLAYER,cep.getDiskColor().getColor());
    }

    @Test
    void resetMoves(){
        cep.setCol(8);
        cep.resetMoves();
        assertEquals(-1,cep.getCol());
    }
}