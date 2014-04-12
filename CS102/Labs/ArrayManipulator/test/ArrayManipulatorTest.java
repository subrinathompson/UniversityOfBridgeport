/*
 * Simple Test Class for ArrayManipulator
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Subrina
 */
public class ArrayManipulatorTest {
    
    private static ArrayManipulator array = new ArrayManipulator(5);
    
    /**
     * Test of add method, of class ArrayManipulator.
     */
    @Test
    public void testAdd() {        
        assertEquals(true, array.add(15));
        assertEquals(true, array.add(5));
        assertEquals(true, array.add(8));
        testDisplay();
    }

    /**
     * Test of find method, of class ArrayManipulator.
     */
    @Test
    public void testFind() {        
        assertEquals(1, array.find(5));  
        
    }

    /**
     * Test of delete method, of class ArrayManipulator.
     */
    @Test
    public void testDelete() {        
        assertEquals(true, array.delete(15));
    }

    /**
     * Test of display method, of class ArrayManipulator.
     */
    @Test
    public void testDisplay() {
        System.out.print("Array using Display Method: ");
        array.display();
    }

    /**
     * Test of toString method, of class ArrayManipulator.
     */
    @Test
    public void testToString() {
        System.out.println("Array using toString Method: " + array);
    }
    
}
