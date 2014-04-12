/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundblaster;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author subrinathompson
 */
public class SoundBlasterDriver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws soundblaster.StackUnderflowError
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, StackUnderflowError {

        // Get music file
        System.out.print("Enter music file: ");
        Scanner readMusicFile = new Scanner(System.in);
        String musicFile = readMusicFile.nextLine();
        Scanner musicFileReader = new Scanner(new FileReader(musicFile));
        boolean sampleNameRead = false;
        String sampleName = "";

        Stack<String> musicStack = new Stack<String>(1000000);
        while (musicFileReader.hasNextLine()) {

            if (!sampleNameRead) {
                // Get the sample name
                sampleName = musicFileReader.nextLine();
                sampleNameRead = true;
            }
            String musicLine = musicFileReader.nextLine();
            musicStack.push(musicLine);
        }

        // Write reversed music to file
        PrintWriter musicFileWriter = new PrintWriter(new FileWriter("reversed_" + musicFile));
        musicFileWriter.println(sampleName);
        while (!musicStack.isEmpty()) {
            musicFileWriter.println(musicStack.top());
            musicStack.pop();
        }
        musicFileReader.close();
        musicFileWriter.close();
    }
}
