package cs102.program.serendipity.bookstore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Subrina on 1/30/14.
 */
public class InventoryMenu {

    private static ArrayList<BookInfo> books;
    private Scanner keyboard;
    private int selection;
    private final String BORDER = "##########################################";
    private static MENU_OPTIONS menuOption;

    private enum MENU_OPTIONS {

        FIND_BOOK,
        ADD_BOOK,
        EDIT_BOOK,
        DELETE_BOOK,
        BACK_TO_MAIN;
    };

    public InventoryMenu() {
        books = new ArrayList<BookInfo>();
        loadBooks();
        keyboard = new Scanner(System.in);
        displayMenu();
    }

    public InventoryMenu(ArrayList<BookInfo> books) {
        this.books = books;
        loadBooks();
    }

    public static ArrayList<BookInfo> getBooks() {
        if (books == null) {
            books = new ArrayList<BookInfo>();
            loadBooks();
        }
        return books;
    }

    private static void loadBooks() {
        try {
            Scanner inFile = new Scanner(new FileReader("books.txt"));

            while (inFile.hasNextLine()) {
                BookInfo b = new BookInfo();

                b.setIsbn(inFile.nextLine());
                b.setTitle(inFile.nextLine());
                b.setAuthor(inFile.nextLine());
                b.setPublisher(inFile.nextLine());
                b.setDateAdded(inFile.nextLine());
                b.setQuantity(Integer.parseInt(inFile.nextLine()));
                b.setWholesaleCost(Double.parseDouble(inFile.nextLine()));
                b.setRetailPrice(Double.parseDouble(inFile.nextLine()));

                books.add(b);
            }
            inFile.close();
        } catch (FileNotFoundException fnfe) {
//            System.out.println("No files yet " + fnfe.getMessage());
        }
    }

    public void closeBooksFile() {
        try {
            PrintWriter output = new PrintWriter(new FileWriter("books.txt"));
            for (BookInfo bookInfo : books) {
                output.println(bookInfo.getIsbn());
                output.println(bookInfo.getTitle());
                output.println(bookInfo.getAuthor());
                output.println(bookInfo.getPublisher());
                output.println(bookInfo.getDateAdded());
                output.println(bookInfo.getQuantity());
                output.println(bookInfo.getWholesaleCost());
                output.println(bookInfo.getRetailPrice());
            }

            output.close();
        } catch (IOException io) {
//            System.out.println("Problem writing to file - " + io.getMessage());
        }
    }

    private void displayMenu() {

        System.out.println("\n" + BORDER + "\n##\tSerendipity Booksellers\t\t##\n"
                + "##\tInventory Database \t\t##\n##\t\t\t\t\t##\n##\t\t\t\t\t##\n"
                + "##\t1. Look Up a Book \t\t##\n"
                + "##\t2. Add a Book \t\t\t##\n"
                + "##\t3. Edit a Book's Record \t##\n"
                + "##\t4. Delete a Book \t\t##\n"
                + "##\t5. Return to the Main Menu \t##\n##\t\t\t\t\t##\n" + BORDER + "\n");
    }

    public void getUserInput() {
        System.out.print("Enter Your Choice: ");
        selection = keyboard.nextInt();
    }

    public void menuSelection() {
        menuOption = MENU_OPTIONS.values()[(selection - 1)];
        switch (menuOption) {
            case FIND_BOOK: // Lookup Book
                lookupBook();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case ADD_BOOK: // Add Book
                addBook();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case EDIT_BOOK: // Edit Book
                editBook();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case DELETE_BOOK: // Delete Book
                deleteBook();
                displayMenu();
                getUserInput();
                menuSelection();
                break;
            case BACK_TO_MAIN: // Return to Main Menu
                closeBooksFile();
                MainMenu menu = new MainMenu();
                System.out.println();
                menu.displayMenu();

                menu.getUserInput();
                menu.menuSelection();
                break;
            default:    // Wrong input
                System.out.println("\n\n\nPlease enter a number in the range 1 - 5");
                getUserInput();
                menuSelection();
        }
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public void deleteBook() {
        keyboard = new Scanner(System.in);
        System.out.println("Delete a Book\n1. By Title\n2. By ISBN");
        System.out.print("\nEnter choice: ");
        int input = -1;
        try {
            input = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException nfe) {
            // Invalid input
        }
        switch (input) {
            case 1:
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();

                BookInfo b = findBookByTitle(title);
                if (b != null) {
                    books.remove(b);
                    System.out.println("Book removed. \n" + BookInfo.getBooksHeader() + b);
                }
                break;
            case 2:
                System.out.print("Enter ISBN: ");
                String isbn = keyboard.nextLine();

                BookInfo b2 = findBookByISBN(isbn);

                if (b2 != null) {
                    books.remove(b2);
                    System.out.println("Book removed. " + b2);
                }
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    public void lookupBook() {
        keyboard = new Scanner(System.in);
        System.out.println("Look up a Book\n1. By Title\n2. By ISBN");
        System.out.print("\nEnter choice: ");
        int input = -1;
        try {
            input = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException nfe) {
            // Invalid input
        }

        switch (input) {
            case 1:
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();

                BookInfo b = findBookByTitle(title);
                if (b != null) {
                    System.out.println("Book found. ");
                    displayBook(b);
                }
                break;
            case 2:
                System.out.print("Enter ISBN: ");
                String isbn = keyboard.nextLine();

                BookInfo b2 = findBookByISBN(isbn);

                if (b2 != null) {
                    System.out.println("Book found. ");
                    displayBook(b2);
                }
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    private void displayBook(BookInfo b) {
        StringBuilder output = new StringBuilder();
        output.append(BookInfo.getBooksHeader());
        output.append(b);
        System.out.println(output.toString());
    }

    private BookInfo findBookByISBN(String isbn) {
        for (BookInfo bookInfo : books) {
            if (bookInfo.getIsbn().trim().equalsIgnoreCase(isbn.trim())) {
                return bookInfo;
            }
        }
        return null;
    }

    public BookInfo findBookByTitle(String title) {

        for (BookInfo bookInfo : books) {
            if (bookInfo.getTitle().equalsIgnoreCase(title)) {
                return bookInfo;
            }
        }
        return null;
    }

    public void addBook() {
        keyboard = new Scanner(System.in);

        BookInfo book = new BookInfo();
        System.out.println("Adding a New Book");
        System.out.print("ISBN: ");
        book.setIsbn(keyboard.nextLine());
        System.out.print("Title: ");
        book.setTitle(keyboard.nextLine());
        System.out.print("Author: ");
        book.setAuthor(keyboard.nextLine());
        System.out.print("Publisher: ");
        book.setPublisher(keyboard.nextLine());
        System.out.print("Date Added: ");
        book.setDateAdded(keyboard.nextLine());
        System.out.print("Quantity: ");
        book.setQuantity(keyboard.nextInt());
        System.out.print("Wholesale Cost: ");
        book.setWholesaleCost(keyboard.nextDouble());
        System.out.print("Retail Price: ");
        book.setRetailPrice(keyboard.nextDouble());

        books.add(book);

        System.out.println("\n=====================\n==   Book Added!   ==\n=====================\n");
    }

    public int getSelection() {
        return this.selection;
    }

    public void editBook() {
        keyboard = new Scanner(System.in);
        System.out.println("Edit a Book. Search\n1. By Title\n2. By ISBN");
        System.out.print("\nEnter choice: ");
        int input = -1;
        try {
            input = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException nfe) {
            // Invalid input
        }
        switch (input) {
            case 1:
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();

                BookInfo b = findBookByTitle(title);
                if (b != null) {
                    editBookDetails(b);
                }
                break;
            case 2:
                System.out.print("Enter ISBN: ");
                String isbn = keyboard.nextLine();

                BookInfo b2 = findBookByISBN(isbn);

                if (b2 != null) {
                    editBookDetails(b2);
                }
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    public void editBookDetails(BookInfo book) {
        keyboard = new Scanner(System.in);

        int input = -1;
        do {
            System.out.println("Edit Book.\n1. Title\n2. ISBN\n3. Publisher\n7.Done");
            System.out.print("\nEnter choice: ");

            try {
                input = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException nfe) {
                // Invalid input
            }
            int index = books.indexOf(book);
            switch (input) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = keyboard.nextLine();

                    books.get(index).setTitle(title);
                    break;
                case 2:
                    System.out.print("Enter ISBN: ");
                    String isbn = keyboard.nextLine();

                    books.get(index).setIsbn(isbn);
                    break;
                case 3:
                    System.out.print("Enter Publisher: ");
                    String publisher = keyboard.nextLine();

                    books.get(index).setPublisher(publisher);
                    break;
                case 7:
                    System.out.println("Done Editing.");
                    closeBooksFile();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

        } while (input != 7);

    }
}
