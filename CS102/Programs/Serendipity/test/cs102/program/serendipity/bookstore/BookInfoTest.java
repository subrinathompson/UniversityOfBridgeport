package cs102.program.serendipity.bookstore;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Subrina on 1/30/14.
 */
public class BookInfoTest {
    @Test
    public void testDisplayBookInformation() throws Exception {
        BookInfo info = new BookInfo();
        Assert.assertNotNull("Book Information -->", info);
//        info.displayBookInformation();
    }
}
