package packages.data_structures.trie;

/**
 * Test controller class for MyTrie.
 */

class TestController {
    public static void main(String[] args) {
        MyTrie t = new MyTrie();
        System.out.println(t.insert("Test"));
        System.out.println(t.insert("Tes"));
        System.out.println(t.insert("hello"));
        System.out.println(t.insert("TeSt"));
        System.out.println("--");
        System.out.println(t.exist("yo"));
        System.out.println(t.exist("test"));
        System.out.println(t.exist("Te"));
        System.out.println(t.exist("Tes"));
        System.out.println(t.exist("Tesb"));
        System.out.println(t.exist("hel"));
        System.out.println(t.exist("hell"));
        System.out.println(t.exist("hellow"));
        System.out.println("--");
        System.out.println(t.remove("Tes"));
        System.out.println("--");
        System.out.println(t.exist("Test"));
        System.out.println(t.exist("hello"));
        System.out.println("--");
        System.out.println(t.remove("Test"));
        System.out.println(t.exist("Test"));
        System.out.println(t.exist("TeSt"));
        System.out.println(t.exist("Te"));
        System.out.println(t.exist("Tes"));

        System.out.println(t.insert("te.st"));

    }
}
