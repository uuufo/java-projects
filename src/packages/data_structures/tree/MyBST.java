package packages.data_structures.tree;

import packages.data_structures.queue.array.MyQueueArray;

import java.util.HashMap;

/**
 * A generic self-balance Binary Search Tree data structure storing key-value pairs.
 *
 * Created by Jared Larsen
 */

public class MyBST<K extends Comparable<K>, V> {

    private BSTNode<K, V> root = null;

    /**
     * Stores a key-value pair in the tree.
     *
     * @param key   of data to be stored
     * @param value of data to be stored
     */
    public void insert(K key, V value) {
        if (root == null) {
            root = new BSTNode<>(key, value);
        } else {
            root = add(key, value, root);
        }
    }

    /**
     * Recursive method called by insert searches tree for existing key-value pair.
     * If key-value pair does not exist, it is added, otherwise the value associated with existing key is updated.
     *
     * @param key   of data to be stored
     * @param value of data to be stored
     * @param node  currently being checked
     * @return new root node after rebalancing (if required)
     */
    private BSTNode<K, V> add(K key, V value, BSTNode<K, V> node) {
        if (node == null) {
            return new BSTNode<>(key, value);
        }
        if (key.compareTo(node.getKey()) < 0) {
            node.left = add(key, value, node.left);
        } else if (key.compareTo(node.getKey()) > 0) {
            node.right = add(key, value, node.right);
        } else {
            node.setValue(value);
        }
        return rebalance(node);
    }

    /**
     * Checks balanceFactor of a node, and calls for rotation if required.
     *
     * @param node to be checked
     * @return new root node if rotation has taken place
     */
    private BSTNode<K, V> rebalance(BSTNode<K, V> node) {
        setHeight(node);
        if (balanceFactor(node) > 1) {
            if (height(node.right.right) <= height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        } else if (balanceFactor(node) < -1) {
            if (height(node.left.left) <= height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    /**
     * Rotates node and its children(left, right) to achieve better balance.
     *
     * @param node parent to be rotated
     * @return new parent
     */
    private BSTNode<K, V> rotateRight(BSTNode<K, V> node) {
        BSTNode<K, V> left = node.left;
        BSTNode<K, V> previousRight = left.right;

        left.right = node;
        node.left = previousRight;

        setHeight(node);
        setHeight(left);

        return left;
    }

    /**
     * Rotates node and its children(left, right) to achieve better balance.
     *
     * @param node parent to be rotated
     * @return new parent
     */
    private BSTNode<K, V> rotateLeft(BSTNode<K, V> node) {
        BSTNode<K, V> right = node.right;
        BSTNode<K, V> previousLeft = right.left;

        right.left = node;
        node.right = previousLeft;

        setHeight(node);
        setHeight(right);

        return right;
    }

    /**
     * Sets the height of a node to its highest child + 1.
     *
     * @param node height to be set
     */
    private void setHeight(BSTNode<K, V> node) {
        node.setHeight(1 + Math.max(height(node.left), height(node.right)));
    }

    /**
     * Returns height of node, or 0 if node = null.
     *
     * @param node to be checked
     * @return height
     */
    private int height(BSTNode<K, V> node) {
        if (node == null) {
            return 0;
        } else {
            return node.getHeight();
        }
    }

    /**
     * Returns balance factor of a node (difference in height of right child and left child).
     *
     * @param node to be checked
     * @return balance factor
     */
    private int balanceFactor(BSTNode<K, V> node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.right) - height(node.left);
        }
    }

    /**
     * Searches tree for key, and returns its paired value if present or null if key does not exist in tree.
     *
     * @param key to be searched for
     * @return value paired to key
     */
    public V search(K key) {
        return get(key, root);
    }

    /**
     * Recursive method called by get to retrieve the value of a key-value pair.
     *
     * @param key  to be searched for
     * @param node currently checked
     * @return value paired to key or null if key does not exist
     */
    private V get(K key, BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getKey()) > 0) {
            return get(key, node.right);
        } else if (key.compareTo(node.getKey()) < 0) {
            return get(key, node.left);
        } else {
            return node.getValue();
        }
    }

    /**
     * Creates a HashMap with all key-value pairs stored in the tree.
     *
     * @return map
     */
    public HashMap<K, V> getMap() {
        HashMap<K, V> map = new HashMap<>();
        MyQueueArray<BSTNode<K, V>> queue = getQueueDFS();
        int s = queue.size();
        for (int i = 0; i < s; i++) {
            BSTNode<K, V> node = queue.poll();
            map.put(node.getKey(), node.getValue());
        }
        return map;
    }

    /**
     * Creates a Queue using all key-value pairs currently stored in the tree using a Depth First Search.
     *
     * @return queue
     */
    private MyQueueArray<BSTNode<K, V>> getQueueDFS() {
        MyQueueArray<BSTNode<K, V>> queue = new MyQueueArray<>();
        return depthFirstSearch(root, queue);
    }

    /**
     * Recursive method using Depth First Search to find all key-value pairs currently stored.
     *
     * @param node  to begin search
     * @param queue to add each result to
     * @return queue
     */
    private MyQueueArray<BSTNode<K, V>> depthFirstSearch(BSTNode<K, V> node, MyQueueArray<BSTNode<K, V>> queue) {
        queue.add(node);
        if (node.left != null) {
            depthFirstSearch(node.left, queue);
        }
        if (node.right != null) {
            depthFirstSearch(node.right, queue);
        }
        return queue;
    }

    /**
     * Prints all items in a queue to the console.
     *
     * @param queue to be printed
     */
    private void print(MyQueueArray<BSTNode<K, V>> queue) {
        int s = queue.size();
        for (int i = 0; i < s; i++) {
            BSTNode<K, V> node = queue.poll();
            System.out.println(node.getKey() + " : " + node.getValue());
        }
    }

    /**
     * Creates a queue using Depth First Search then prints it to the console.
     */
    public void printDepthFirst() {
        MyQueueArray<BSTNode<K, V>> queue = getQueueDFS();
        print(queue);
    }

    /**
     * Creates a Queue using all key-value pairs currently stored in the tree using a Breadth First Search.
     *
     * @return queue
     */
    private MyQueueArray<BSTNode<K, V>> getQueueBFS() {
        MyQueueArray<BSTNode<K, V>> tempQueue = new MyQueueArray<>();
        MyQueueArray<BSTNode<K, V>> queue = new MyQueueArray<>();
        tempQueue.add(root);
        breadthFirstSearch(tempQueue, queue);
        return queue;
    }

    /**
     * Iterative method using Breadth First Search to find all key-value pairs currently stored in the tree.
     *
     * @param tempQueue used to iterate through results
     * @param queue     to contain results
     */
    private void breadthFirstSearch(MyQueueArray<BSTNode<K, V>> tempQueue, MyQueueArray<BSTNode<K, V>> queue) {
        while (!tempQueue.isEmpty()) {
            BSTNode<K, V> node = tempQueue.poll();
            queue.add(node);
            if (node.right != null)
                tempQueue.add(node.right);
            if (node.left != null)
                tempQueue.add(node.left);
            breadthFirstSearch(tempQueue, queue);
        }
    }

    /**
     * Creates a queue using Breadth First Search then prints it to the console.
     */
    public void printBreadthFirst() {
        MyQueueArray<BSTNode<K, V>> queue = getQueueBFS();
        print(queue);
    }

    /**
     * Removes a key-value pair stored in the tree.
     *
     * @param key of the pair to be removed
     */
    public void remove(K key) {
        root = delete(key, root);
    }

    /**
     * Recursive method called by remove to search tree for key-value pair and delete it.
     *
     * @param key  to be removed
     * @param node to begin search
     * @return node currently being searched
     */
    private BSTNode<K, V> delete(K key, BSTNode<K, V> node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getKey()) > 0) {
            node.right = delete(key, node.right);
        } else if (key.compareTo(node.getKey()) < 0) {
            node.left = delete(key, node.left);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                BSTNode<K, V> iterator = node.right;
                while (iterator.left != null) {
                    iterator = iterator.left;
                }
                node.setKey(iterator.getKey());
                node.right = delete(node.getKey(), node.right);
            }
        }
        return rebalance(node);
    }
}

/**
 * POJO of our BSTNode object.
 * Stores a key-value pair, references left and right children BSTNodes, and height of child nodes.
 *
 * @param <K> key type
 * @param <V> value type
 */
class BSTNode<K, V> {

    private K key;
    private V value;
    BSTNode<K, V> left;
    BSTNode<K, V> right;
    private int height;

    public BSTNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
