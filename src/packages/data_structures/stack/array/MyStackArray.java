package packages.data_structures.stack.array;

import packages.data_structures.exceptions.EmptyStackException;

import java.util.Arrays;

/**
 * A generic Stack data structure based on an underlying array.
 *
 * @param <T> data type to be used with stack
 *
 * Created by Jared Larsen
 *
 */

public class MyStackArray<T> {

    private T[] stack;
    private T[] tempStack;

    /**
     * Constructor for initial array creation.
     * Minimum array size of 8, or the closest multiple of 8 to the number of varargs.
     * @param data to be added
     */
    @SuppressWarnings("unchecked")
    public MyStackArray(T... data) {
        if (data.length < 6) {
            stack = (T[]) new Object[8];
        } else {
            int a = (data.length / 8) * 8;
            int b = a + 8;
            int x = (data.length - a > b - data.length) ? b : a;
            stack = (T[]) new Object[x];
        }
        for (T item : data) {
            push(item);
        }
    }

    /**
     * Adds item to the top of the stack.
     * Increases array size as required.
     * @param data to be added
     */
    public void push(T data) {
        int count = 0;
        while (stack[count] != null) {
            count++;
            if (count + 1 >= stack.length - (stack.length / 4)) {
                tempStack = Arrays.copyOf(stack, stack.length * 2);
                stack = Arrays.copyOf(tempStack, tempStack.length);
            }
        }
        for (int i = count; i > -1; i--) {
            if (i > 0) {
                stack[i] = stack[i - 1];
            }
        }
        stack[0] = data;
    }

    /**
     * Removes item from top of stack.
     * Decreases array size when possible.
     * @return the removed item
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException {
        if (stack[0] == null) {
            throw new EmptyStackException();
        }
        T data = stack[0];
        System.arraycopy(stack, 1, stack, 0, stack.length - 1);

        int count = 0;
        while (stack[count] != null) {
            count++;
        }
        if (count <= stack.length / 4 && count > 2) {
            tempStack = Arrays.copyOf(stack, stack.length / 2);
            stack = Arrays.copyOf(tempStack, tempStack.length);
        }
        return data;
    }

    /**
     * Counts current items in the stack, regardless of actual array size.
     * @return count
     */
    public int size() {
        int count = 0;
        for (T s : stack) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Prints all current items in the stack to console, along with current stack size() and array size.
     */
    public void print() {
        for (T s : stack) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
        System.out.println("Current items in stack: " + size());
        System.out.println("Current array length: " + stack.length);
    }

    /**
     * Finds item at bottom of stack.
     * @return item
     */
    public T peakBottom() {
        if (stack[0] == null) {
            return null;
        }
        int count = 0;
        while (stack[count] != null) {
            count++;
        }
        return stack[count - 1];
    }

    /**
     * Finds item at top of stack.
     * @return item
     */
    public T peakTop() {
        return stack[0];
    }
}

