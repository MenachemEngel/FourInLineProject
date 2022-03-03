package tests;

import game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewsFactoryTest {

    ViewsSubject viewsSubject = new ViewsSubject();
    ViewsObserver viewsObserver;
    ViewsFactory viewsFactory = new ViewsFactory();

    @Test
    void getView() {
        viewsObserver = viewsFactory.getView(TextualView.class.getName(), viewsSubject);
        assertEquals(TextualView.class.getName(), viewsObserver.getClass().getName());
    }

    @Test
    void getView2() {
        viewsObserver = viewsFactory.getView(GraphicalView.class.getName(), viewsSubject);
        assertEquals(GraphicalView.class.getName(), viewsObserver.getClass().getName());
    }

    @Test
    void getView3() {
        viewsObserver = viewsFactory.getView(null, viewsSubject);
        assertNull(viewsObserver);
    }

    @Test
    void getView4() {
        viewsObserver = viewsFactory.getView("null", viewsSubject);
        assertNull(viewsObserver);
    }

}