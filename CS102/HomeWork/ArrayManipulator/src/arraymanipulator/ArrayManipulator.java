/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymanipulator;

/**
 *
 * @author Subrina
 */
public class ArrayManipulator {

    int [] data;
    private int size;

    public ArrayManipulator() {
        this(10);
    }

    public ArrayManipulator(int size) {
        this.size = size;        
        this.data = new int [size];
    }
    
    
}
