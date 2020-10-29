package packages.data_structures.linkedlist;

class MyLinkedList<T> {

    Node<T> head;

    @SafeVarargs
    public MyLinkedList(T... data) {
        if (data.length < 1) {
            head = null;
        } else {
            for (T datum : data) {
                addLast(datum);
            }
        }
    }

    /**
     * This methods checks to see if the list contains a given element.
     * @param data to search for
     * @return true or false - false if the item is not found in the list or the list is empty
     */
    public boolean contains(T data) {
        if (head != null) {
            Node<T> iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.data != data) {
                    iterator = iterator.next;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds an item to the end of the list.
     * @param data to be added
     */
    public void addLast(T data) {
        if (head != null) {
            Node<T> iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.next != null) {
                    iterator = iterator.next;
                } else {
                    iterator.next = new Node<T>(data, iterator);
                }
            }
        } else {
            head = new Node<>(data);
        }
    }

    /**
     * Adds an item to the front of the list.
     * @param data to be added
     */
    public void addFirst(T data) {
        Node<T> first = new Node<>(data);
        first.next = head;
        head.prev = first;
        head = first;
    }

    /**
     * Removes the item specified by name.
     * @param data name of item to be removed
     * @return item or null if the list is empty
     */
    public T remove(T data) {
        if (head != null) {
            Node<T> iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.data != data) {
                    iterator = iterator.next;
                } else {
                    iterator.prev.next = iterator.next;
                    return iterator.data;
                }
            }
        }
        return null;
    }

    /**
     * Removes the first item in the list.
     * @return the removed item or null if list is empty
     */
    public T removeFirst() {
        if (head == null) {
            return null;
        } else {
            Node<T> temp = head;
            head = head.next;
            return temp.data;
        }
    }

    /**
     * Removes the last item in the list.
     * @return the removed item or null if the list is empty
     */
    public T removeLast() {
        if (head == null) {
            return null;
        } else {
            Node<T> iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.next != null) {
                    iterator = iterator.next;
                } else {
                    iterator = iterator.prev;
                    iterator.next = null;
                }
            }
            return iterator.data;
        }
    }

    /**
     * Counts the number of items in the list.
     * @return count
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node<T> iterator = head;
        while (iterator.next != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    /**
     * Returns item at the specified position in the list.
     * @param index position in list
     * @return item
     */
    public T get(int index) {
        Node<T> iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }
        return iterator.data;
    }

    /**
     * Prints the current list to the console.
     */
    public void print() {
        System.out.println(size());
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data, Node<T> prev) {
        this.data = data;
        this.next = null;
        this.prev = prev;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}