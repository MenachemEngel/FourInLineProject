package tests;

import game.Disk;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskTest {

    Disk d = new Disk('O', 5, 3);
    @Test
    void drawTest() {
        d.draw();
        assertEquals('O' ,d.getColor());
        assertEquals(5,d.getR());
        assertEquals(3,d.getC());
    }

    @Test
    void getRadiusTest() {
        d.setRadius(4);
        assertEquals(4, d.getRadius());
    }

    @Test
    void setRadiusTest() {
        d.setRadius(4);
        assertEquals(4, d.getRadius());
    }

    @Test
    void getColorTest() {
        assertEquals('O', d.getColor());
    }

    @Test
    void setColorTest() {
        d.setColor('X');
        assertEquals('X', d.getColor());
    }

    @Test
    void getRTest() {
        assertEquals(5, d.getR());
    }

    @Test
    void setRTest() {
        d.setR(6);
        assertEquals(6, d.getR());
    }

    @Test
    void getCTest() {
        assertEquals(3, d.getC());
    }

    @Test
    void setCTest() {
        d.setC(7);
        assertEquals(7,d.getC());
    }
}