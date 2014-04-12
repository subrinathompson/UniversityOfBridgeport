package cs102.program.serendipity.bookstore;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Subrina on 1/30/14.
 */
public class InventoryMenuTest {
    InventoryMenu menu;

    @Before
    public void setUp() throws Exception {
        menu = new InventoryMenu();
    }

    @Test
    public void testDisplayMenu() throws Exception {
        Assert.assertNotNull("Inventory Menu -->", menu);
//        menu.displayMenu();

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
