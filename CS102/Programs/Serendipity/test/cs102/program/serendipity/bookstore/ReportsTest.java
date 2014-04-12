package cs102.program.serendipity.bookstore;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Subrina on 1/30/14.
 */
public class ReportsTest {

    Reports menu;

    @Before
    public void setUp() throws Exception {
        menu = new Reports();
    }

    @Test
    public void testDisplayMenu() throws Exception {
        Assert.assertNotNull("Reports Menu -->", menu);
        menu.displayMenu();
    }

    @Test
    public void testMenuSelectionError() {
        menu.setSelection(-1);
        System.out.println("Menu Choice: " + menu.getSelection());
        menu.menuSelection();

        org.junit.Assert.assertNotSame(7, menu.getSelection());

    }

    @Test
    public void testMenuSelectionValid() {

        menu.setSelection(3);
        System.out.println("Menu Choice: " + menu.getSelection());
        menu.menuSelection();

        org.junit.Assert.assertSame(3, menu.getSelection());
    }
}
