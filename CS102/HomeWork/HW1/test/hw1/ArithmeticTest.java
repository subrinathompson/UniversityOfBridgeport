/*
 *  A simple test case for generic arithmetic types
 */
package hw1;

import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Subrina
 */
public class ArithmeticTest {

    private static ArrayList<Arithmetic<String, Double>> testDoubles = new ArrayList<Arithmetic<String, Double>>();
    private static Random random;

    @Before
    public void setUp() {
        testDoubles = new ArrayList<Arithmetic<String, Double>>();
    }

    /**
     * Test the Arithmetic class using Doubles.
     */
    @Test
    public void testDoubles() throws Exception {
        // Doubles
        for (int i = 0; i < 10; i++) {
            testDoubles.add(new Arithmetic("" + getRandomOperator(), 5.0, 5.0));
        }

        Report r = new Report();
        r.setData(testDoubles);
        System.out.println("Results:\n" + r);

        for (Arithmetic<String, Double> arithmetic : testDoubles) {
            if (arithmetic.getOperator().equals("+")) {
                assertEquals(new Double(10.0), arithmetic.getResult());
            } else if (arithmetic.getOperator().equals("-")) {
                assertEquals(new Double(0.0), arithmetic.getResult());
            } else if (arithmetic.getOperator().equals("*")) {
                assertEquals(new Double(25.0), arithmetic.getResult());
            }
             else if (arithmetic.getOperator().equals("/")) {
                assertEquals(new Double(1.0), arithmetic.getResult());
            }
        }
    }

    public static char getRandomOperator() {
        random = new Random();
        int randNum = random.nextInt(4);
        if (randNum == 0) {
            return '+';
        } else if (randNum == 1) {
            return '-';
        } else if (randNum == 2) {
            return '*';
        } else {
            return '/';
        }
    }

    public static int getRandomIntOperand() {
        random = new Random();

        return random.nextInt(20);
    }
}
