package packages.data_structures.trie;

import java.util.ArrayList;

/**
 * A case-sensitive Trie data structure for use with English alphabet Strings.
 *
 * Created by Jared Larsen
 */

public class MyTrie {

    private final TrieNode root = new TrieNode(false);

    /**
     * Stores a String in the Trie.
     *
     * @param word String to be stored
     * @return true if new String has been added, false if String was already present
     */
    public boolean insert(String word) {
        int[] index = getIndex(word);
        TrieNode iterator = root;
        if (search(word)) {
            return false;
        } else {
            for (int i : index) {
                if (iterator.children[i] == null) {
                    iterator.children[i] = new TrieNode(false);
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
        TrieNode iterator = root.children[index[0]];
        TrieNode previous = iterator;

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
     * Specifies the array index where a char is to be represented.
     *
     * @param c char to represent
     * @return index where char is represented in underlying array
     * @throws IllegalCharacterException if characters other than standard letters are used
     */
    private int charToIndex(char c) throws IllegalCharacterException {
        if (Character.isLowerCase(c)) {
            return (c - 71);
        } else if (Character.isUpperCase(c)) {
            return (c - 65);
        } else {
            throw new IllegalCharacterException();
        }
    }

    /**
     * Takes an index location of an array and returns the char represented by that index
     *
     * @param i index representing char
     * @return char
     */
    private char indexToChar(int i) {
        if (i < 26) {
            return (char) (i + 65);
        } else {
            return (char) (i + 71);
        }
    }

    /**
     * Gets index locations of the underlying array(s) for each character in a String.
     *
     * @param word String to be indexed
     * @return array of index locations
     */
    private int[] getIndex(String word) {
        int[] index = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            index[i] = charToIndex(word.charAt(i));
        }
        return index;
    }

    /**
     * Checks if String is currently stored in the Trie.
     *
     * @param word String to search for
     * @return true if String is currently stored, false if it is not
     */
    public boolean search(String word) {
        int[] index = getIndex(word);
        TrieNode iterator = root.children[index[0]];

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
     * Searches for all words stored in the Trie.
     *
     * @return ArrayList of words.
     */
    public ArrayList<String> getWords() {
        ArrayList<String> result = new ArrayList<>();
        traverse(result, "", root);
        return result;
    }

    /**
     * Traverse each array of children recursively until all words are found.
     *
     * @param result   ArrayList to store complete words
     * @param word     String built with characters found in children
     * @param iterator Node to be actively traversed
     */
    private void traverse(ArrayList<String> result, String word, TrieNode iterator) {
        if (iterator.isEnd()) {
            result.add(word);
        }
        for (int i = 0; i < 52; i++) {
            if (iterator.children[i] != null) {
                traverse(result, word + indexToChar(i), iterator.children[i]);
            }
        }
    }

    /**
     * Simple POJO representing a Node in our Trie.
     * Each Node contains a children array of 52 (26 uppercase letters + 26 lowercase letters).
     */
    static class TrieNode {
        private boolean end;
        public TrieNode[] children;

        public TrieNode(Boolean end) {
            this.children = new TrieNode[52];
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

