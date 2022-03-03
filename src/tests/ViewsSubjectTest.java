package tests;

import game.GraphicalView;
import game.TextualView;
import game.ViewsSubject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewsSubjectTest {

    ViewsSubject viewsSubject = new ViewsSubject();

    @Test
    void getState() {
        viewsSubject.attach(new TextualView(viewsSubject));
        viewsSubject.attach(new GraphicalView(viewsSubject));
        viewsSubject.setState("hello");
        assertEquals("hello", viewsSubject.getState());
    }

    /*@Test
    void setState() {
    }*/

    @Test
    void attach() {
        viewsSubject.attach(new TextualView(viewsSubject));
        viewsSubject.attach(new GraphicalView(viewsSubject));
        assertNotNull(viewsSubject.getObserver(0));
    }

    /*@Test
    void notifyAllObservers() {
    }*/
}