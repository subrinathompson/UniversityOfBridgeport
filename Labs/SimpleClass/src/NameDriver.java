/**
 *
 * @author Subrina
 */
public class NameDriver {
    public static void main(String[] args) {
        String f, l, m;
        
        f = "Susy";
        l = "Blah";
        m = "A";
        displayFullName(f, l, m);
        
        Name n1;
        n1 = new Name();
        displayFullName(n1.getF(), n1.getL(), n1.getM());
        
        Name n2;
        n2 = new Name("Frida", "Randen", "C");
        displayFullName(n2.getF(), n2.getL(), n2.getM());
        
        System.out.println(n2.getF() + " " + n2.getM() + ". " + n2.getL());
        
    }
    public static void displayFullName(String f, String l, String m) {
        System.out.println(f + " " + m + ". " + l);
    }
}
