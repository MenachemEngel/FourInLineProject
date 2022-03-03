package tests;

import game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {

    MenuFactory menuFactory = new MenuFactory();
    IMenu menu;

    @Test
    void getMenu() {
        menu = menuFactory.getMenu(StartMenu.class.getName());
        assertEquals(StartMenu.class.getName(), menu.getClass().getName());
    }

    @Test
    void getMenu2() {
        menu = menuFactory.getMenu(BoardMenu.class.getName());
        assertEquals(BoardMenu.class.getName(), menu.getClass().getName());
    }

    @Test
    void getMenu3() {
        menu = menuFactory.getMenu(LevelMenu.class.getName());
        assertEquals(LevelMenu.class.getName(), menu.getClass().getName());
    }

    @Test
    void getMenu4() {
        menu = menuFactory.getMenu(null);
        assertNull(menu);
    }

    @Test
    void getMenu5() {
        menu = menuFactory.getMenu(" ");
        assertNull(menu);
    }

}