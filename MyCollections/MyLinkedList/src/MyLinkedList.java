import java.util.Arrays;

/**
 * A doubly linked list implementation in Java.
 */
public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Adds a new value to the end of the list.
     *
     * @param value the value to add
     */
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds a new value at the specified index in the list.
     *
     * @param index the index to add the value at
     * @param value the value to add
     */
    public void add(int index, E value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node<E> newNode = new Node<>(value);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node<E> currentNode;
            if (index < size / 2) {
                currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size - 1; i > index - 1; i--) {
                    currentNode = currentNode.prev;
                }
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
        }
        size++;
    }

    /**
     * Returns value at the specified index in the list.
     *
     * @param index the index to return value at
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index or size is 0");
        } else {
            Node<E> currentNode;
            if (index < size / 2) {
                currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size - 1; i > index; i--) {
                    currentNode = currentNode.prev;
                }
            }
            return currentNode.value;
        }
    }

    /**
     * Returns index at the specified value in the list.
     *
     * @param value the value to return index at
     */
    public int search(E value) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == value) return i;
            currentNode = currentNode.next;
        }
        return -1;
    }

    /**
     * Replaces value at the specified index in the list.
     *
     * @param index the index to replace the value at
     * @param value the value to replace
     */
    public void replace(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index or size is 0");
        } else {
            Node<E> currentNode;
            if (index < size / 2) {
                currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size - 1; i > index; i--) {
                    currentNode = currentNode.prev;
                }
            }
            currentNode.value = value;
        }
    }

    /**
     * Removes value at the specified index in the list.
     *
     * @param index the index to remove the value at
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index or size is 0");
        }
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.prev;
        } else {
            Node<E> currentNode;
            if (index < size / 2) {
                currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
            } else {
                currentNode = tail;
                for (int i = size - 1; i > index - 1; i--) {
                    currentNode = currentNode.prev;
                }
            }
            currentNode.next.next.prev = currentNode;
            currentNode.next = currentNode.next.next;
        }
        size--;
    }

    /**
     * Returns size of list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns all elements as a string.
     */
    @Override
    public String toString() {
        Object[] elements = new Object[size];
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            elements[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return Arrays.toString(elements);
    }

    /**
     * Represents a node in the linked list.
     */
    private static class Node<E> {

        private Node<E> next;
        private Node<E> prev;
        private E value;

        private Node(E value) {
            this.value = value;
        }
    }
}