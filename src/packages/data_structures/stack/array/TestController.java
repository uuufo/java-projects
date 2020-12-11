package packages.data_structures.stack.array;

import packages.data_structures.exceptions.EmptyStackException;

/**
 *      To test soundness of MyStackArray class.
 *
 */

class TestController {
    public static void main(String[] args) throws EmptyStackException {
        MyStackArray<String> stack = new MyStackArray<>("1", "2", "3", "4");
        stack.print();
        stack.push("5");
        stack.print();
        stack.push("6");
        stack.print();
        stack.push("7");
        stack.print();
        stack.push("8");
        stack.print();

        System.out.println("First item in stack: " + stack.peakBottom());
        System.out.println("Last item in stack: " + stack.peakTop());

        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.size());

        System.out.println("First item in stack: " + stack.peakBottom());
        System.out.println("Last item in stack: " + stack.peakTop());

        for (int i = 1; i < 101; i++) {
            stack.push(Integer.toString(i + 100));
        }
        stack.print();
        String s = stack.pop();
        System.out.println(s);

    }
}

