package cs102.program.serendipity.bookstore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Subrina on 1/30/14.
 */
public class Reports {

    private static SORT_TYPES sortType;
    private static MENU_OPTIONS menuOption;

    private Scanner keyboard;
    private int selection;
    private final String BORDER = "##########################################";

    public static enum SORT_TYPES {

        QUANTITY,
        COST,
        AGE;
    };

    public static enum MENU_OPTIONS {

        INVENTORY_LISTING,
        INVENTORY_WHOLESALE_VALUE,
        INVENTORY_RETAIL_VALUE,
        LISTING_BY_QUANTITY,
        LISTING_BY_COST,
        LISTING_BY_AGE,
        BACK_TO_MAIN;
    };

    public Reports() {
        keyboard = new Scanner(System.in);
        displayMenu();
    }

    public void setSortType(SORT_TYPES sortType) {
        Reports.sortType = sortType;
    }
    
    

    public void displayMenu() {
        System.out.println("\n" + BORDER + "\n##\tSerendipity Booksellers\t\t##\n"
                + "##\tMain Menu \t\t\t##\n##\t\t\t\t\t##\n##\t\t\t\t\t##\n"
                + "##\t1. Inventory Listing \t\t##\n"
                + "##\t2. Inventory Wholesale Value \t##\n"
                + "##\t3. Inventory Retail Value \t##\n"
                + "##\t4. Listing by Quantity \t\t##\n"
                + "##\t5. Listing by Cost \t\t##\n"
                + "##\t6. Listing by Age \t\t##\n"
                + "##\t7. Return to the Main Menu \t##\n##\t\t\t\t\t##\n" + BORDER + "\n");
    }

    public void getUserInput() {
        System.out.print("Enter Your Choice: ");
        selection = keyboard.nextInt();
    }

    public void menuSelection() {
        menuOption = MENU_OPTIONS.values()[(selection - 1)];
        switch (menuOption) {
            case INVENTORY_LISTING:
                displayAllBooks();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case INVENTORY_WHOLESALE_VALUE:
                listByWholesaleValue();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case INVENTORY_RETAIL_VALUE:
                listByWholesaleValue();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case LISTING_BY_QUANTITY:
                sortType = SORT_TYPES.QUANTITY;
                sortBooks();
                displayAllBooks();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case LISTING_BY_COST:
                sortType = SORT_TYPES.COST;
                sortBooks();
                displayAllBooks();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case LISTING_BY_AGE:
                sortType = SORT_TYPES.AGE;
                sortBooks();
                displayAllBooks();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case BACK_TO_MAIN:
                MainMenu menu = new MainMenu();
                System.out.println();
                menu.displayMenu();
                menu.getUserInput();
                menu.menuSelection();
                break;
            default:
                System.out.println("\n\n\nPlease enter a number in the range 1 - 7");
                selection = -1;
        }
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public int getSelection() {
        return this.selection;
    }

    private void displayAllBooks() {
        System.out.println("\nBook Listings\n");
        StringBuilder output = new StringBuilder();
        output.append(BookInfo.getBooksHeader());
        for (BookInfo book : InventoryMenu.getBooks()) {
            output.append(book).append("\n");
        }
        System.out.println(output.toString());
    }

    public String getAllBooks() {
        System.out.println("\nBook Listings\n");
        StringBuilder output = new StringBuilder();
        output.append(BookInfo.getBooksHeader());
        for (BookInfo book : InventoryMenu.getBooks()) {
            output.append(book).append("\n");
        }
        return (output.toString());
    }

    public void listByWholesaleValue() {

        ArrayList<BookInfo> books = InventoryMenu.getBooks();
        Collections.sort(books, new Comparator<BookInfo>() {
            @Override
            public int compare(BookInfo b1, BookInfo b2) {
                if (b1.getWholesaleCost() == b2.getWholesaleCost()) {
                    return 0;
                } else if (b1.getWholesaleCost() > b2.getWholesaleCost()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        System.out.println("Book Listing by Quantity\n\n" + books);
    }

    public void sortBooks() {
        ArrayList<BookInfo> books = InventoryMenu.getBooks();
        Collections.sort(books, new Comparator<BookInfo>() {
            @Override
            public int compare(BookInfo b1, BookInfo b2) {

                switch (sortType) {
                    case QUANTITY:
                        if (b1.getQuantity() == b2.getQuantity()) {
                        return 0;
                    } else if (b1.getQuantity() > b2.getQuantity()) {
                        return 1;
                    } else {
                        return -1;
                    }
                    case COST:
                        if (b1.getWholesaleCost() == b2.getWholesaleCost()) {
                        return 0;
                    } else if (b1.getWholesaleCost() > b2.getWholesaleCost()) {
                        return 1;
                    } else {
                        return -1;
                    }
                    case AGE:
                        DateFormat f = new SimpleDateFormat("dd/MM/yy");
                        try {
                            return f.parse(b1.getDateAdded()).compareTo(f.parse(b2.getDateAdded()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    default:
                        return -1;
                }

            }
        });
    }
}
