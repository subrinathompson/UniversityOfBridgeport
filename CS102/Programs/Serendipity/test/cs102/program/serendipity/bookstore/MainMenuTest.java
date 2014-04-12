/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.program.serendipity.bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Subrina
 */
public class MainMenuTest {
    private MainMenu menu;

    @Before
    public void setUp() throws Exception {
        menu = new MainMenu();
    }

    /**
     * Test of displayMenu method, of class MainMenu.
     */
    @Test
    public void testDisplayMenu() {

        Assert.assertNotNull("MainMenu -->", menu);
        menu.displayMenu();
    }

    @Test
         public void testMenuSelectionError() {
        menu.setSelection(-1);
        System.out.println("Menu Choice: " + menu.getSelection());
        menu.menuSelection();

        Assert.assertNotSame(7, menu.getSelection());

    }

    @Test
    public void testMenuSelectionValid() {

        menu.setSelection(3);
        System.out.println("Menu Choice: " + menu.getSelection());
        menu.menuSelection();

        Assert.assertSame(3, menu.getSelection());
    }
}
