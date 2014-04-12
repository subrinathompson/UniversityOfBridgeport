/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadratic;

import java.util.Scanner;

/**
 *
 * @author Subrina
 */
public class Quadratic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a, b, c;
        double x1, x2;
        
        System.out.print("Enter a: ");
        a = in.nextDouble();
        System.out.print("Enter b: ");
        b = in.nextDouble();
        System.out.print("Enter c: ");
        c = in.nextDouble();
        
        double root = Math.sqrt((b*b) - (4*a*c));
        x1 = (-b + root)/(2*a);
        x2 = (-b - root)/(2*a);
        System.out.println("Quadratic solution: "
                + "\n\tx1 = " + x1 + ", x2= " + x2);
        
    }
    
}
