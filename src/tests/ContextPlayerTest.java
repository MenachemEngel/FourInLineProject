package tests;

import game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextPlayerTest {

    ContextPlayer contextPlayer;
    ViewsSubject viewsSubject = new ViewsSubject();
    PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void executeOperationTest() {
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

        contextPlayer = new ContextPlayer(playerFactory.getPlayer(ComputerHardPlayer.class.getName()));
        contextPlayer.executeOperation(board,viewsSubject);
        assertArrayEquals(b2,board.getBoard());
    }

    @Test
    void executeOperationTest2() {
        contextPlayer = new ContextPlayer(playerFactory.getPlayer(ComputerEasyPlayer.class.getName()));
        assertNotNull(contextPlayer.getPlayerStrategy());
    }

    @Test
    void executeOperationTest3() {
        contextPlayer = new ContextPlayer(playerFactory.getPlayer(HumanPlayer.class.getName()));
        assertNotNull(contextPlayer.getPlayerStrategy());
    }

    @Test
    void executeOperationTest4() {
        contextPlayer = new ContextPlayer(playerFactory.getPlayer(null));
        assertNull(contextPlayer.getPlayerStrategy());
    }

    @Test
    void executeOperationTest5() {
        contextPlayer = new ContextPlayer(playerFactory.getPlayer("hello"));
        assertNull(contextPlayer.getPlayerStrategy());
    }

    @Test
    void executeOperationTest6() {
        contextPlayer = new ContextPlayer(playerFactory.getPlayer("hello"));
        contextPlayer.setPlayerStrategy(new HumanPlayer());
        assertNotNull(contextPlayer.getPlayerStrategy());
    }
}