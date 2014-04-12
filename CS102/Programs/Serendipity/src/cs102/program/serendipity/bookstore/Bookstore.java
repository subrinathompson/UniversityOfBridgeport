package cs102.program.serendipity.bookstore;

import java.util.Scanner;

/**
 * Created by Subrina on 2/2/14.
 */
public class Bookstore {
    public static void main(String[] args) {        

        MainMenu menu = new MainMenu();
                                
        System.out.println("Welcome to Serendipity Booksellers.\n\nPlease select from the menu options below...");
        menu.displayMenu();

        menu.getUserInput();
        menu.menuSelection();
    }
}
