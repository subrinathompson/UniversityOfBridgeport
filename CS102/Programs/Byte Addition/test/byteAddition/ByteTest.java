/*
 * Test created to verify the logic within Byte class is correct.
 */
package byteAddition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Subrina
 */
public class ByteTest
{

    @Before
    public void setUp() throws Exception
    {
        Byte b1 = new Byte();
        assertNotNull(b1);
    }

    @Test
    public void testDefaultByteConstructor()
    {
        Byte defaultByte = new Byte();

        String expectedResult = "00000000";
        String result = String.valueOf(defaultByte);

        assertEquals("Expecting a 0 bit array.", expectedResult, result);
    }

    @Test
    public void testConstructorWithBitsAsNullArg()
    {
        Byte nullArg = new Byte((char[]) null);

        String expectedResult = "00000000";
        String result = String.valueOf(nullArg);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testConstructorWithByteAsArg()
    {
        Byte testByte = new Byte();
        String expectedValue = "00000000";
        assertEquals(expectedValue, testByte.toString());
    }

    @Test
    public void getMagnitudeOfNullByte()
    {
        Byte defaultByte = new Byte((char[]) null);
        int expectedValue = 0;
        assertEquals(expectedValue, defaultByte.magnitude());
    }

    @Test
    public void getMaginuteOfNonZeroByte()
    {
        char[] byte22 =
        {
            '0', '0', '0', '1', '0', '1', '1', '0'
        };
        Byte defaultByte = new Byte(byte22);
        int expectedValue = 22;
        assertEquals(expectedValue, defaultByte.magnitude());
    }

    @Test
    public void biasedTo2sComplement()
    {
        char[] byteValue =
        {
            '0', '0', '0', '1', '0', '1', '1', '0'
        };
        Byte defaultByte = new Byte(byteValue);
        String expectedValue = "10010110";
        assertEquals(expectedValue, defaultByte.biasedTo2sComplement().toString());
    }

    @Test
    public void to2sComplement()
    {
        char[] byteValue =
        {
            '1', '0', '0', '1', '0', '1', '1', '0'
        };
        Byte defaultByte = new Byte(byteValue);
        String expectedValue = "01101010";
        assertEquals(expectedValue, defaultByte.to2sComplement().toString());
    }

    @Test
    public void add()
    {
        char[] byteValue =
        {
            '1', '0', '0', '1', '0', '1', '1', '0'
        };
        Byte byte1 = new Byte(byteValue);
        Byte byte2 = new Byte(byteValue);
        String expectedValue = "00101100";
        assertEquals(expectedValue, byte1.add(byte2).toString());
    }

    @Test
    public void testUnderflow()
    {
        char[] byteValue =
        {
            '1', '0', '0', '1', '0', '1', '1', '0'
        };
        Byte byte1 = new Byte(byteValue);
        Byte byte2 = new Byte(byteValue);
        Byte sum = byte1.add(byte2);
        
        String expectedValue = Byte.UNDERFLOW;
        assertEquals(expectedValue, sum.finalResult(byte1, byte2));
    }

    @Test
    public void testOverflow()
    {
        char[] byteValue =
        {
            '0', '1', '0', '1', '0', '1', '1', '0'
        };
        Byte byte1 = new Byte(byteValue);
        Byte byte2 = new Byte(byteValue);

        Byte sum = byte1.add(byte2);
        String expectedValue = Byte.OVERFLOW;
        assertEquals(expectedValue, sum.finalResult(byte1, byte2));
    }

    @Test
    public void displayResult()
    {

        Byte byte1 = new Byte(new char[]
        {
            '1', '0', '0', '0', '0', '0', '0', '1'
        });
        Byte byte2 = new Byte(new char[]
        {
            '0', '0', '0', '0', '0', '0', '0', '0'
        });

        Byte byte22 = byte2.biasedTo2sComplement();                
        Byte sum = byte1.add(byte22);
        sum.displayResult(byte1, byte2);

                
        System.out.println("\n");

        Byte byte3 = new Byte(new char[]
        {
            '0', '0', '0', '1', '0', '1', '1', '0'
        });
        Byte byte4 = new Byte(new char[]
        {
            '1', '0', '0', '0', '0', '0', '1', '1'
        });

        Byte byte44 = byte4.biasedTo2sComplement();
        Byte sum2 = byte3.add(byte44);

        sum2.displayResult(byte3, byte4);

    }

    /**
     * Test of toString method, of class Byte.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Byte instance = new Byte();
        String expResult = "00000000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}