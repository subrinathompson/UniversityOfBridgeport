/*
 * A Simple Program to demonstrate the use of 
 * System.out.print and System.out.println
 */
package basicjavasyntax;

/**
 *
 * @author Subrina
 * @date March 1, 2014
 */
public class BasicJavaSyntax
{
    public static void main(String[] args)
    {
        System.out.println("Question 1:	Prints your name in large letters, such as\n");
        System.out.println("*   *     **      ****     ****    *   *");
        System.out.println("*   *    *  *     *   *    *   *   *   *");
        System.out.println("*****   ******    ****     ****     * *");
        System.out.println("*   *   *    *    *   *    *   *     *");
        System.out.println("*   *   *    *    *    *   *    *    *");

        System.out.println("\nQuestion 2:	Prints a tic-tac-toe board:\n");
        System.out.println("+---+---+---+");
        System.out.println("|   |   |   |");
        System.out.println("+---+---+---+");
        System.out.println("|   |   |   |");
        System.out.println("+---+---+---+");
        System.out.println("|   |   |   |");
        System.out.println("+---+---+---+");

        System.out.println("\nQuestion 3: Write code to print the following groups of text.\n");
        System.out.println("Four score \n"
                + "and seven years ago");
        System.out.println("Four score \n"
                + "and seven\n"
                + "years ago");

        System.out.println("\nQuestion 4: Write code to print the following pretty print.\n");

        System.out.println("     *                 *");
        System.out.print("   * * *             * * *\n");
        System.out.print(" * * * * * ####### * * * * *\n");
        System.out.println("   * * *             * * *");
        System.out.println("     *      @    @     *");
        System.out.println("     *         ^       *");
        System.out.println("      *     $$$$$$$   *");
        System.out.println("        *            *");
        System.out.println("          * * * * *");

    }
}