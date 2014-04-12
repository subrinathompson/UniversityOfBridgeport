
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Subrina
 */
public class GUIInput {
    public static void main(String[] args) {
        String name;
        int age;
        String ageString;
        double weight;
        String weightString;
        double weightLb;
        final double KG_LB_RATIO = 2.2;
        
        name = JOptionPane.showInputDialog(null, "Enter your name", "User Input", JOptionPane.QUESTION_MESSAGE);
        ageString = JOptionPane.showInputDialog(null, "Enter your age", "User Input", JOptionPane.QUESTION_MESSAGE);
        weightString = JOptionPane.showInputDialog(null, "Enter your weight in kg", "User Input", JOptionPane.QUESTION_MESSAGE);
        
        age = Integer.parseInt(ageString);
        
        weight = Double.parseDouble(weightString);
        weightLb = weight * KG_LB_RATIO;        
        String weightLbString = String.format("%.2f", weightLb);
        
        JOptionPane.showMessageDialog(null, name + ", your weight is " + weightLbString + " pounds");
    }
}
