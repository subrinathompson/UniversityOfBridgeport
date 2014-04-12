import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Subrina
 */
public class StudentGrades {

    private final int MAX_NAME = 11;
    private final int MAX_SSN = 10;
    private final int SCORE_COUNT = 4;

    private char[] studentNameArray;
    private char[] ssnArray;
    private final double[] scoresArray;
    private double scoreAverage3, scoreAverage;

    private String studentName, ssn;
    private static int scoreIndex = 0;
    

    public StudentGrades(Scanner input) {

        scoresArray = new double[SCORE_COUNT];
        
        while (input.hasNext()) {
            studentName = input.next();
            loadStudentName();
            ssn = input.next();
            loadSSN();

            for (int i = 0; i < SCORE_COUNT; i++) {
                loadGrades(input.nextDouble());
            }
            gradeStatistics();
            printResults();
            scoreIndex = 0;
        }
    }

    private void loadStudentName() {

        if (studentName != null && studentName.length() > 0) {

            int nameLength = studentName.length() < MAX_NAME ? studentName.length() : MAX_NAME;

            studentNameArray = new char[nameLength];
            
            for (int i = 0; i < nameLength; i++) {
                studentNameArray[i] = studentName.charAt(i);
            }
        }
    }

    private void loadSSN() {
        if (ssn != null && ssn.length() > 0) {

            int ssnLength = ssn.length() < MAX_SSN ? ssn.length() : MAX_SSN;
            ssnArray = new char[ssnLength];
            
            for (int i = 0; i < ssnLength; i++) {
                ssnArray[i] = ssn.charAt(i);
            }
        }
    }

    private void loadGrades(double grade) {
        scoresArray[scoreIndex++] = grade;
    }
    
    private void gradeStatistics() {
        double scoreSum3 = 0;
        for (int i = 0; i < scoresArray.length; i++) {
            
            if(i != 3) {
                scoreSum3 += scoresArray[i];                  
            }else {
                scoreAverage3 += (scoresArray[i] /SCORE_COUNT) * 0.40;
            }
                    
        }
        scoreAverage3 += (scoreSum3 / SCORE_COUNT) * 0.20;
    }
    
    public final void printResults() {
        System.out.println("NAME");
        System.out.println(Arrays.toString(studentNameArray));
    }
}
