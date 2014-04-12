/*
 * Demonstrating the use of a simple data structure.
 */

/**
 *
 * @author Subrina
 */
public class ArrayManipulator {
    private int[] data;
    private int size;
    private int location;

    public ArrayManipulator() {
        this(10);
    }

    public ArrayManipulator(int size) {
        this.size = size;
        this.location = 0;
        this.data = new int[this.size];
    }

    /**
     * Adds an element to the data array.
     *
     * @param element
     * @return true if add was successful, false otherwise.
     */
    public boolean add(int element) {
        if (location == size) {
            return false;
        }

        data[location] = element;
        location += 1;
        return true;
    }

    /**
     * Tries to find an element in the array
     *
     * @param element
     * @return -1 if the element does not exist, other the index of the first
     * occurrence of the element
     */
    public int find(int element) {
        for (int i = 0; i < location; i++) {
            if (data[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Tries to delete an element from the array
     *
     * @param element
     * @return
     */
    public boolean delete(int element) {
        int index = find(element);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < location-1; i++) {
            data[i] = data[i + 1];
        }
        location -= 1;

        return true;
    }

    /**
     * Displays all the elements in the array
     */
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder dataString = new StringBuilder("[");

        for (int i = 0; i < (location - 1); i++) {
            dataString.append(data[i]).append(", ");
        }
        dataString.append(data[location - 1]).append("]");

        return dataString.toString();
    }
}
