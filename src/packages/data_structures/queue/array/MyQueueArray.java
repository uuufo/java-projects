package packages.data_structures.queue.array;

import java.util.Arrays;

/**
 * A generic Queue data structure based on an underlying array.
 *
 * @param <T> data type to be used with stack
 *
 * Created by Jared Larsen
 *
 */

class MyQueueArray<T> {

    private T[] queue;
    private T[] tempQueue;

    /**
     * Constructor for initial array creation.
     * Minimum array size of 8, or the closest multiple of 8 to the number of varargs.
     * @param data to be added
     */
    @SuppressWarnings("unchecked")
    public MyQueueArray(T... data) {
        if (data.length < 6) {
            queue = (T[]) new Object[8];
        } else {
            int a = (data.length / 8) * 8;
            int b = a + 8;
            int x = (data.length - a > b - data.length) ? b : a;
            queue = (T[]) new Object[x];
        }
        for (T item : data) {
            add(item);
        }
    }

    /**
     * Adds item to the queue.
     * Increases array size as required.
     * @param data to be added
     */
    public void add(T data) {
        int count = 0;
        System.out.println(data);
        while (queue[count] != null) {
            count++;
            if (count + 1 >= queue.length - (queue.length / 4)) {
                tempQueue = Arrays.copyOf(queue, queue.length * 2);
                queue = Arrays.copyOf(tempQueue, tempQueue.length);
            }
        }
        queue[count] = data;
    }

    /**
     * Uses dequeue() to remove the first item in the queue.
     * @return removed item
     * @throws EmptyQueueException if queue is empty
     */
    public T remove() throws EmptyQueueException {
        if (queue[0] == null) {
            throw new EmptyQueueException();
        } else {
            return dequeue();
        }
    }

    /**
     * Uses dequeue() to remove the first item in the queue.
     * Similar to remove() but returns null if the queue is empty.
     * @return removed item
     */
    public T poll() {
        if (queue[0] == null) {
            return null;
        } else {
            return dequeue();
        }
    }

    /**
     * Removes first item from queue and decreases size of array if reasonable.
     * @return removed item
     */
    private T dequeue() {
        T data = queue[0];
        System.out.println(data);
        System.arraycopy(queue, 1, queue, 0, queue.length - 1);

        int count = 0;
        while (queue[count] != null) {
            count++;
        }
        if (count <= queue.length / 4 && count > 2) {
            tempQueue = Arrays.copyOf(queue, queue.length / 2);
            queue = Arrays.copyOf(tempQueue, tempQueue.length);
        }
        return data;
    }

    /**
     * Counts current items in the queue, regardless of actual array size.
     * @return count
     */
    public int size() {
        int count = 0;
        for (T s : queue) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Prints all current items in the queue to console, along with current queue size() and array size.
     */
    public void print() {
        for (T s : queue) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
        System.out.println("Current items in queue: " + size());
        System.out.println("Current array length: " + queue.length);
    }

    /**
     * @return last item in the queue
     */
    public T peakLast() {
        if (queue[0] == null) {
            return null;
        }
        int count = 0;
        while (queue[count] != null) {
            count++;
        }
        return queue[count - 1];
    }

    /**
     * * @return first item in the queue
     */
    public T peakFirst() {
        return queue[0];
    }
}

class EmptyQueueException extends Exception {
    @Override
    public String toString() {
        return "EmptyQueueException - There is nothing to remove();";
    }
}