package tests;

import game.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller();

    @Test
    void printBoard() {
        controller.printBoard("1","2");
        assertNotNull(controller);
    }
}