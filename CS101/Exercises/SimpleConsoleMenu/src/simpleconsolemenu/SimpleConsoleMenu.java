/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleconsolemenu;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Subrina
 */
public class SimpleConsoleMenu {

    private static Scanner in;
    private static String [] name;
    private static int[] ssn;
    private static float[][] grades;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader("infile"));
        name = new String[10];
        ssn = new int [8];
        grades = new float[10][4];
        
        getGrades();
//        System.out.println("testing clear console");
//        
//        System.out.println("\f");
//        
//        Console c = System.console();
//        System.out.println(c);
//        System.out.println("Now this should show up");
    }
    
    public static void getGrades() {
        while(in.hasNextLine()){
            for(int i = 0; i < name.length; i++){
                name[i] = in.next();
                ssn[i] = in.nextInt();
                
                for(int j = 0; j < 4; j++){
                    grades[i][j] = in.nextFloat();
                }
                in.nextLine();
            }
        }
    }    
}
