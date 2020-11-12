package packages.data_structures.hashmap;

import java.util.Set;

class TestController {
    public static void main(String[] args) {
        MyHashMap<Integer, String> m = new MyHashMap<>();
        MyHashMap<String, Integer> m2 = new MyHashMap<>();


        System.out.println(m.isEmpty());
        System.out.println(m2.isEmpty());

        for (int i = 5000; i < 5100; i++) {
            m.put(i, "Test");
        }
        for (int i = 300; i < 400; i++) {
            m2.put("Test" + i, i);
        }

        Set<Integer> keys = m.keySet();
        Set<String> keys2 = m2.keySet();
        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.get(100));
        System.out.println(m.get(5050));
        System.out.println(m2.get("Test500"));
        System.out.println(m2.get("Test361"));

        System.out.println(m.remove(100));
        System.out.println(m.remove(5050));
        System.out.println(m2.remove("Test500"));
        System.out.println(m2.remove("Test361"));

        keys = m.keySet();
        keys2 = m2.keySet();
        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.get(5050));
        System.out.println(m2.get("Test361"));

        for (int i = 5000; i < 5050; i++) {
            m.remove(i);
        }

        keys = m.keySet();
        keys2 = m2.keySet();

        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.isEmpty());
        System.out.println(m2.isEmpty());

    }
}

