package byteAddition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ByteDriver {

    public static void main(String[] args) throws IOException {
        String twosComplementFormat = "  %-10s\t\t2's Complement\t\t  %-15d";
        String biasedFormat = "+ %-10s\t\tBiased Notation\t\t+ %-15d";
        String sumFormat = "  %-10s\t\t2's Complement\t\t+ %-15d";
        String line = "  %-10s\t\t               \t\t%-15s";

        Scanner input = new Scanner(new FileReader("input.txt"));
        PrintWriter output = new PrintWriter(new FileWriter("output.txt"));

        while (input.hasNext()) {
            String byte1String = input.next();
            String byte2String = input.next();

            char[] bits1 = byte1String.toCharArray();
            char[] bits2 = byte2String.toCharArray();

            Byte byte1 = new Byte(bits1);  // 2's complement notation 
            Byte byte2 = new Byte(bits2);   // biased notation 
            Byte byte2To2sComplement = byte2.biasedTo2sComplement();
            Byte sumByte = byte1.add(byte2To2sComplement);

            int byte1Sum = byte1.magnitude();
            int byte2Sum = byte2To2sComplement.magnitude();
            int decimalSum = byte1Sum + byte2Sum;
            String finalResult = sumByte.finalResult(byte1, byte2To2sComplement);

            output.println(String.format(twosComplementFormat, byte1, byte1Sum));
            output.println(String.format(biasedFormat, byte2, byte2Sum));
            output.println(String.format(line, "--------", "------"));
            output.println(String.format(sumFormat, finalResult, decimalSum));
            output.println();
            
            
            sumByte.displayResult(byte1, byte2);
            System.out.println();
        }

        output.close();
        input.close();
    }
}
