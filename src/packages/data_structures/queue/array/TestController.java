package packages.data_structures.queue.array;

import packages.data_structures.exceptions.EmptyQueueException;

/**
 *      To test soundness of MyQueueArray class.
 *
 */

class TestController {
    public static void main(String[] args) throws EmptyQueueException {
        MyQueueArray<Integer> queue = new MyQueueArray<>(1, 2, 3, 4, 5, 6);
        queue.add(7);
        queue.add(8);
        queue.print();
        queue.remove();
        queue.print();
        int y = queue.remove();
        queue.print();
        queue.poll();
        queue.print();
        int x = queue.poll();
        System.out.println(x + " " + y);

        for (int i = 1; i < 101; i++) {
            queue.add(i + 100);
        }
        queue.print();
        System.out.println("First item in queue: " + queue.peakFirst());
        System.out.println("Last item in queue: " + queue.peakLast());
        for (int i = queue.size(); i > 0; i--) {
            queue.remove();
        }
    }
}

