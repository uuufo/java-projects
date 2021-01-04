package packages.data_structures.tree;

import java.util.HashMap;

/**
 * Test controller class for MyBST.
 */

class TestController {
    public static void main(String[] args) {
        MyBST<Integer, String> m = new MyBST<>();

        m.insert(20, "Test.20");
        m.insert(15, "Test.15");
        m.insert(10, "Test.10");
        m.insert(5, "Test.5");

        m.insert(4, "Test.4");
        m.insert(11, "Test.11");
        m.insert(14, "Test.14");
        m.insert(22, "Test.22");
        m.insert(16, "Test.16");
        m.insert(9, "Test.9");
        m.insert(2, "Test.2");
        m.insert(1, "Test.1");
        System.out.println();
        m.insert(5, "Test.Update");
        m.insert(15, "Test.Update");
        m.insert(2, "Test.Update");

        for (int i = 0; i < 100; i++) {
            m.insert(i, "Test-" + i);
        }

        System.out.println(m.search(5));
        System.out.println(m.search(20));
        System.out.println(m.search(2));
        System.out.println(m.search(10));
        System.out.println(m.search(15));

        m.remove(9);
        m.remove(5);
        for (int i = 25; i < 100; i++) {
            m.remove(i);
        }

        System.out.println(m.search(5));
        m.remove(5);

        System.out.println(m.search(9));
        System.out.println(m.search(20));
        HashMap<Integer, String> map = m.getMap();
        System.out.println("-------------------------");
        m.printDepthFirst();
        System.out.println("-------------------------");
        m.printBreadthFirst();
    }
}
