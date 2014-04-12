/*
 * Generic Stack ADT
 */

package soundblaster;

/**
 * A generic stack
 * @param <E>
 * @date Mar 10, 2012
 * @author subrinathompson
 */
public class Stack<E> {
    private E [] data;
    private int top = -1;

    public Stack()
    {
        this(10);   // default size of 10
    }

    public Stack(int size)
    {
        this.data = (E []) new Object [size];
    }

    /**
     * Tries to add an element to a stack. If it wasn't successful, an exception
     * is thrown
     * @param element
     * @return
     * @throws StackOverflowError
     */
    public boolean push(E element) throws StackOverflowError {
        if(!isFull()){
            this.data[++top] = element;
            return true;
        }
        throw new StackOverflowError("Cannot add to a full stack!");
    }

    public boolean pop() throws StackUnderflowError {
        if(!isEmpty()) {
            top--;
            return true;
        }
        throw new StackUnderflowError("Cannot pop an empty stack!");
    }
    
    public E top() {
        return this.data[top];
    }
    
    public boolean isFull()
    {
        return ((top + 1) == this.data.length);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder stackString = new StringBuilder();
        for(int i = 0; i < (top+1); i++){
            stackString.append("| ").append(this.data[i]).append("|");                    
        }
        return stackString.toString();
    }        
}
