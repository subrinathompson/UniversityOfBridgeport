/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pay;

import java.util.Scanner;

/**
 *
 * @author Subrina
 */
public class Pay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float hours, rate, pay;
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many hours did you work? ");
        hours = input.nextFloat();
        
        System.out.print("How much did you get paid per hour? ");
        rate = input.nextFloat();
        
        pay = hours * rate;
        
        System.out.println("You have earned $" + pay);
    }    
}