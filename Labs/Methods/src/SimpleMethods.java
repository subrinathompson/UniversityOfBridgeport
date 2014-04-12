

/**
 *
 * @author Subrina
 */
public class SimpleMethods {
    
    // Main Method
    public static void main(String[] args) {
        System.out.println("Hello there");
        displayMessage("Testing displayMessage method");
        
        add(4, 5);
        add(15, 21);
        
        subtract(4, 2);
        
        displayMessage("5");
        
        int c = multiply(8, 2);
        System.out.println("Value of c: " + c);
        
        System.out.println("Product: " + multiply(4, 2));
    }
    
    public static void displayMessage(String message) {
        System.out.println(message);
    }
    
    public static void add(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }
    
    public static void subtract(int x, int y) {
        System.out.println("Difference = " + (x-y));
    }
    
    public static int multiply(int a, int b) {
        int prod = a * b;
        return prod;
    }
}
