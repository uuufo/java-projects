package packages.data_structures.linkedlist;

/**
 * To test soundness of MyLinkedList class.
 */

class TestController {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>("Talon", "Rider");

        list.addLast("Jared");
        list.addFirst("Rowan");
        list.addLast("Jen");
        list.addFirst("Miley");

        System.out.println(list.contains("Jared"));
        System.out.println(list.contains("Sally"));
        System.out.println("- - - - -");

        list.print();

        System.out.println(list.removeFirst());
        list.print();

        System.out.println(list.removeLast());
        list.print();

        list.remove("Talon");
        list.print();
    }
}

