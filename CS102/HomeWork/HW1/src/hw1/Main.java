package hw1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Subrina on 2/8/14.
 */
public class Main {

    private static Random random;

    public static void main(String[] args) throws Exception {

        ArrayList<Arithmetic> myArithmeticObjects = new ArrayList<Arithmetic>();

        // Integers
        for (int i = 0; i < 10; i++) {
            myArithmeticObjects.add(new Arithmetic(getRandomOperator(), getRandomIntOperand(), getRandomIntOperand()));
        }

        Report r = new Report();
        r.setData(myArithmeticObjects);

//        // Doubles
//        for (int i = 0; i < 10; i++) {
//            myArithmeticObjects.add(new Arithmetic(getRandomOperator(), getRandomDoubleOperand(), getRandomDoubleOperand()));
//        }
//
//        r.setData(myArithmeticObjects);

        System.out.println(r);
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

    public static double getRandomDoubleOperand() {
        random = new Random();

        return random.nextDouble();
    }
}
