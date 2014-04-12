package cs102.program.serendipity.bookstore;

import java.util.Scanner;
import javax.print.DocFlavor;

/**
 * Created by Subrina on 1/30/14.
 */
public class Cashier {

    private String userDate;
    private int quantity;
    private String isbn;
    private String title;
    private float unitPrice;

    public Cashier() {
//        this.userDate = null;
        getUserInformation();
    }

    private void getUserInformation() {
        Scanner in = new Scanner(System.in);
        boolean correct = false;
        do {
            System.out.print("Enter Date: ");
            userDate = in.nextLine();

            if (userDate.matches("\\d{2}\\/\\d{2}\\/\\d{2}")) {
                correct = true;
            } else {
                System.out.println("Incorrect format, try again\n\\d{2}\\/\\d{2}\\/\\d{2}");
            }
        } while (correct != true);

        System.out.print("Enter Quantity: ");
        quantity = 0;
        try {
            quantity = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException nfe) {
        }

        correct = false;
        do {
            System.out.print("Enter ISBN: ");
            isbn = in.nextLine();

            if (isbn.matches("\\d{1}\\-\\d{3}\\-\\d{5}-\\d{1}")) {
                correct = true;
            } else {
                System.out.println("Incorrect format, try again\n\\d{1}\\-\\d{3}\\-\\d{5}-\\d{1}");
            }
        } while (!correct);

        System.out.print("Enter Title: ");
        title = in.nextLine();

        System.out.print("Enter Unit Price: ");
        unitPrice = 0.0f;
        try {
            unitPrice = Float.parseFloat(in.nextLine());
        } catch (NumberFormatException nfe) {
        }
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void displayScreen() {
        float total = getQuantity() * getUnitPrice();
        System.out.println("Serendipity Booksellers");
        System.out.println("\nDate: " + getUserDate());
        System.out.println("\nQty\t\tISBN\t\tTitle\t\t\t\t\t\t\tPrice\t\tTotal ");
        System.out.println("___________________________________________________________________________________________________");
        System.out.printf("%d\t\t%s\t\t%s\t\t\t\t\t\t\t%.2f\t\t%.2f", getQuantity(), getIsbn(), getTitle(), getUnitPrice(), total);
        System.out.println("\n\n\t\t\t\t\tSubtotal ");
        System.out.println("\t\t\t\t\tTax ");
        System.out.println("\t\t\t\t\tTotal ");
        System.out.println("\n\nThank You for Shopping at Serendipity ");
    }
}
