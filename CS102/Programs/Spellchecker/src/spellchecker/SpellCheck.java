package spellchecker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simple spell check program User: Subrina Date: 2/1/12 Time: 10:31 PM
 */
public class SpellCheck {

    // Used to store the dictionary words
    private static ArrayList<String> inWordList;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        // Step 1: Ask the user to enter a file name
        Scanner inFileName = new Scanner(System.in);
        System.out.print("Please provide a file name: ");
        String fileName = inFileName.nextLine();

        // Step 2: Check to make sure a file name was entered
        if (fileName.length() <= 0) {
            System.err.println("No file name provided. Closing now...");
            System.exit(0);
        }
        System.out.println("File name: " + fileName);

        // Step 3: Call the method to store all the words in the dictionary file to the array list
        storeDictionary();

        // Step 4: Start processing the file if there are lines to process
        Scanner inFile = new Scanner(new FileReader(fileName));
        int currentLine = 0;
        while (inFile.hasNextLine()) {
            ++currentLine;         // Used to keep track of the line being read
            String line = inFile.nextLine();
            String[] lineList = line.split("[^A-Za-z]");   // Split the line by all special characters and store in an array

            for (String word : lineList) {
                // If the word is an empty string, don't process it.
                if (word.isEmpty()) {
                    continue;
                }

                // Call the find word method to search for the current word.
                boolean found = findWord(word);

                // If the word was not found, print the current line and identify the misspelled word.
                if (!found) {
                    // Error found
                    String lineOutput = String.format("Line %02d: ", currentLine);
                    System.out.println(lineOutput + line);

                    for (int i = 0; i < line.indexOf(word) + lineOutput.length(); i++) {
                        System.out.print(' ');
                    }
                    for (int i = 0; i < word.length(); i++) {
                        System.out.print('^');
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * Method used to store all the dictionary words from the file into an array
     * list
     *
     * @throws IOException
     */
    private static void storeDictionary() throws FileNotFoundException {
        Scanner inWords = new Scanner(new FileReader("words.txt"));

        inWordList = new ArrayList<String>();
        while (inWords.hasNext()) {
            inWordList.add(inWords.next());
        }
    }

    /**
     * Look up a word from the input file in the dictionary of words using
     * iterative search
     *
     * @param word
     * @return
     */
    private static boolean findWord(String word) {
        for (String currentWord : inWordList) {
            if (currentWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
