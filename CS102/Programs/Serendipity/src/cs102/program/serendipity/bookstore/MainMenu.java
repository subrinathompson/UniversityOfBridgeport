package cs102.program.serendipity.bookstore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Subrina
 */
public class MainMenu {

    private final String BORDER = "##########################################";
    private int selection;
    private Scanner keyboard;
private static MENU_OPTIONS menuOption;

    private enum MENU_OPTIONS {

        CASHIER_MODULE,
        INVENTORY_DATABASE_MODULE,
        REPORT_MODULE,
        EXIT;
    };

    public MainMenu() {
        keyboard = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n" + BORDER + "\n##\tSerendipity Booksellers\t\t##\n"
                + "##\t\tMain Menu \t\t##\n##\t\t\t\t\t##\n##\t\t\t\t\t##\n"
                + "##\t1. Cashier Module \t\t##\n"
                + "##\t2. Inventory Database Module \t##\n"
                + "##\t3. Report Module \t\t##\n"
                + "##\t4. Exit \t\t\t##\n##\t\t\t\t\t##\n" + BORDER + "\n");
    }

    public void getUserInput() {
        System.out.print("Enter Your Choice: ");
        selection = keyboard.nextInt();
    }

    public void menuSelection() {
        menuOption = MENU_OPTIONS.values()[(selection - 1)];
        switch (menuOption) {
            case CASHIER_MODULE:
                                Cashier cashier = new Cashier();
                cashier.displayScreen();
                break;
            case INVENTORY_DATABASE_MODULE:
                InventoryMenu inventory = new InventoryMenu();
                inventory.getUserInput();
                inventory.menuSelection();
                break;
            case REPORT_MODULE:
                Reports report = new Reports();
                report.getUserInput();
                report.menuSelection();
                break;
            case EXIT:
                System.out.println("Thank You For Shopping at Serendipity!");
                break;
            default:
                System.out.println("\n\n\nPlease enter a number in the range 1 - 4");
                getUserInput();
                menuSelection();
        }
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public int getSelection() {
        return this.selection;
    }
}
