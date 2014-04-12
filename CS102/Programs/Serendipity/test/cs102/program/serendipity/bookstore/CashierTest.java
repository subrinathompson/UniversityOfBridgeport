package cs102.program.serendipity.bookstore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Subrina on 1/30/14.
 */
public class CashierTest {

    @Test
    public  void testDisplayScreen() {

        Cashier screen = new Cashier();
        Assert.assertNotNull("MainMenu object created.", screen);
        screen.displayScreen();

    }

    @Test
    public  void testCashierScreen() {

        Cashier screen = new Cashier();
        Assert.assertNotNull("MainMenu object created.", screen);

        screen.setUserDate("3/31/03");
        screen.setQuantity(2);
        screen.setIsbn("0-333-90123-8");
        screen.setTitle("History of Scotland");
        screen.setUnitPrice(19.95f);
        screen.displayScreen();

    }

}
