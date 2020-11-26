package packages.data_structures.trie;

/**
 * A case-sensitive Trie data structure for use with English alphabet Strings.
 *
 * Created by Jared Larsen
 *
 */

public class MyTrie {

    private final Node root = new Node(false);

    /**
     * Stores a String in the Trie.
     *
     * @param word String to be stored
     * @return true if new String has been added, false if String was already present
     */
    public boolean insert(String word) {
        int[] index = getIndex(word);
        Node iterator = root;
        if (exist(word)) {
            return false;
        } else {
            for (int i : index) {
                if (iterator.children[i] == null) {
                    iterator.children[i] = new Node(false);
                }
                iterator = iterator.children[i];
            }
            iterator.setEnd(true);
        }
        return true;
    }

    /**
     * Removes entry from the Trie.
     *
     * @param word String to be removed
     * @return true if String was removed, false if String was not present
     */
    public boolean remove(String word) {
        int[] index = getIndex(word);
        Node iterator = root.children[index[0]];
        Node previous = iterator;

        if (iterator == null) {
            return false;
        } else {
            for (int i = 1; i < index.length; i++) {
                previous = iterator;
                iterator = iterator.children[index[i]];
                if (iterator == null) {
                    return false;
                }
            }
        }
        if (iterator.isEnd()) {
            for (int i = 0; i < 52; i++) {
                if (iterator.children[i] != null) {
                    iterator.setEnd(false);
                    return true;
                }
            }
            previous.children[index[index.length - 1]] = null;
        } else {
            return false;
        }
        return true;
    }

    /**
     * Finds the array index where a specific char is represented.
     * @param c char to represent
     * @return index where char is represented in underlying array
     * @throws IllegalCharacterException
     */
    private int charLocation(char c) throws IllegalCharacterException {
        if (Character.isLowerCase(c)) {
            return (c - 71);
        } else if (Character.isUpperCase(c)) {
            return (c - 65);
        } else {
            throw new IllegalCharacterException();
        }
    }

    /**
     * Gets index locations of the underlying array(s) for each character in a String.
     * @param word String to be indexed
     * @return array of index locations
     */
    private int[] getIndex(String word) {
        int[] index = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            index[i] = charLocation(word.charAt(i));
        }
        return index;
    }

    /**
     * Checks if String is currently stored in the Trie.
     * @param word String to search for
     * @return true if String is currently stored, false if it is not
     */
    public boolean exist(String word) {
        int[] index = getIndex(word);
        Node iterator = root.children[index[0]];

        if (iterator == null) {
            return false;
        } else {
            for (int i = 1; i < index.length; i++) {
                iterator = iterator.children[index[i]];
                if (iterator == null) {
                    return false;
                }
            }
        }
        return iterator.isEnd();
    }

    /**
     * Simple POJO representing a Node in our Trie.
     * Each Node contains a children array of 52 (26 uppercase letters + 26 lowercase letters).
     */
    static class Node {
        private boolean end;
        public Node[] children;

        public Node(Boolean end) {
            this.children = new Node[52];
            this.end = end;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }
    }

    static class IllegalCharacterException extends RuntimeException {
        @Override
        public String toString() {
            return "IllegalCharacterException - only letters from the English alphabet are allowed.";
        }
    }
}

