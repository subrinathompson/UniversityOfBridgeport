/*
 * Byte class
 */
package byteAddition;

/**
 *
 * @author Subrina
 */
public class Byte
{

    public static final String TWO_COMPL_STR = "\t\t2's complement\t\t  ";
    public static final String OVERFLOW = "Overflow";
    public static final String UNDERFLOW = "Underflow";

    private char[] bits;
    private final int BIT_SIZE = 8;
    private final char[] DEFAULT_BITS =
    {
        '0', '0', '0', '0', '0', '0', '0', '0'
    };
    private final char[] BYTE_ONE =
    {
        '0', '0', '0', '0', '0', '0', '0', '1'
    };

    /**
     * *
     * Creates a new byte with default char array of all '0'.
     */
    public Byte()
    {
        this.bits = new char[BIT_SIZE];
        for (int i = 0; i < this.bits.length; i++)
        {
            this.bits[i] = '0';
        }
    }

    /**
     * Creates a new byte with user inputted char array.
     *
     * @param bits
     */
    public Byte(char[] bits)
    {
        if (bits == null)
        {
            bits = new char[BIT_SIZE];
            System.arraycopy(DEFAULT_BITS, 0, bits, 0, DEFAULT_BITS.length);
        }
        this.bits = new char[BIT_SIZE];
        System.arraycopy(bits, 0, this.bits, 0, this.bits.length);
    }

    public Byte(Byte b)
    {
        if (b != null)
        {
            this.bits = new char[BIT_SIZE];
            System.arraycopy(b.bits, 0, this.bits, 0, this.bits.length);
        } else
        {

        }
    }

    /**
     * Calculate the integer value of a byte
     *
     * @return
     */
    public int magnitude()
    {
        int result = 0;

        Byte b = new Byte(this);
        b = b.to2sComplement();

        for (int i = b.bits.length - 1, exp = 0; i >= 0; i--, exp++)
        {
            int value = b.bits[i] == '0' ? 0 : 1;
            result += Math.pow(2, exp) * value;
        }

        return this.bits[0] == '1' ? (-1) * result : result;
    }

    /**
     * Converts the current from biased to 2's complement
     *
     * @return a newByte
     */
    public Byte biasedTo2sComplement()
    {
        Byte newByte = new Byte(this.bits);

        // Flip the highest order bit 
        newByte.bits[0] = newByte.bits[0] == '0' ? '1' : '0';

        return newByte;
    }

    /**
     * Adds two byte together and returns the result in a new Byte object
     *
     * @param addByte
     * @return sum of two bytes
     */
    public Byte add(Byte addByte)
    {
        int carry = 0;
        Byte sumByte = new Byte(this.bits);

        for (int i = sumByte.bits.length - 1; i >= 0; i--)
        {
            int bit1Value = sumByte.bits[i] == '0' ? 0 : 1;
            int bit2Value = addByte.bits[i] == '0' ? 0 : 1;

            int result = bit1Value + bit2Value + carry;

            switch (result)
            {
                case 0:
                    sumByte.bits[i] = '0';
                    carry = 0;
                    break;
                case 1:
                    sumByte.bits[i] = '1';
                    carry = 0;
                    break;
                case 2:
                    sumByte.bits[i] = '0';
                    carry = 1;
                    break;
                case 3:
                    sumByte.bits[i] = '1';
                    carry = 1;
                    break;
                default:
                    break;
            }
        }

        return new Byte(sumByte.bits);
    }

    /**
     * Converts a byte to 2's complement.
     *
     * @return a new byte
     */
    public Byte to2sComplement()
    {
        Byte newByte = new Byte(this.bits);
        // The number is negative 
        if (newByte.bits[0] == '0')
        {
            return newByte;
        }

        for (int i = 0; i < newByte.bits.length; i++)
        {
            newByte.bits[i] = newByte.bits[i] == '0' ? '1' : '0';
        }

        Byte one = new Byte(BYTE_ONE);

        // Add one 
        return newByte.add(one);
    }

    /**
     * Format a byte into a string
     *
     * @return a String representation of a Byte.
     */
    private String formatByte()
    {
        StringBuilder byteString = new StringBuilder();

        for (int i = 0; i < bits.length; i++)
        {
            byteString.append(bits[i]);
        }

        return byteString.toString();
    }

    /**
     * Checks if the summation results in an overflow, underflow or a valid
     * result.
     *
     * @param b1
     * @param b2
     * @return string representation of result
     */
    public String finalResult(Byte b1, Byte b2)
    {
        if (b1.bits[0] == '0' && b2.bits[0] == '0' && this.bits[0] == '1')
        {
            return OVERFLOW;
        } else if (b1.bits[0] == '1' && b2.bits[0] == '1' && this.bits[0] == '0')
        {
            return UNDERFLOW;
        } else
        {
            return this.toString();
        }
    }

    /**
     * Displays the result of adding two bytes.
     *
     * @param b1
     * @param b2
     */
    public void displayResult(Byte b1, Byte b2)
    {
        StringBuilder byteResult = new StringBuilder();
        
        int byte1Magnitude = b1.magnitude();
        int byte2Magnitude = b2.biasedTo2sComplement().magnitude();
        
        byteResult.append("  ").append(b1).append(TWO_COMPL_STR).append(byte1Magnitude);
        byteResult.append("\n").append("+ ").append(b2).append("\t\tbiased notation\t\t").append("+ ").append(byte2Magnitude);
        byteResult.append("\n  --------").append(TWO_COMPL_STR).append("----\n");

        int resultMagnitude = finalResult(b1, b2.biasedTo2sComplement()).equals(UNDERFLOW) || finalResult(b1, b2.biasedTo2sComplement()).equals(OVERFLOW) ? (byte1Magnitude + byte2Magnitude) : magnitude();
        byteResult.append("  ").append(finalResult(b1, b2.biasedTo2sComplement())).append("\t\t\t\t\t  ").append(resultMagnitude);

        System.out.println(byteResult);
    }

    /**
     * String representation of byte in a formatted string
     *
     * @return String representation of a byte
     */
    @Override
    public String toString()
    {
        return formatByte();
    }
}
