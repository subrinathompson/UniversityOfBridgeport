
public class CatDriver
{

    public static void main(String[] args)
    {

        Cat c1;
        c1 = new Cat("Meow", "blue", 10.5f);
        System.out.println(c1.toString());

        Cat c2 = new Cat("Oli", "brow", 20.0f);
        System.out.println(c2);
        System.out.println("My cat: " + c1.getName() + " is "
                + c1.getColor() + " and weighs " + c1.getWeight()
                + " lbs.");
    }
}
