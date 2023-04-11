import java.util.Arrays;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void add(int value) {
        if (head == null) {
            this.head = new Node(value);
            this.tail = head;
        } else {
            Node temp = tail;
            Node newNode = new Node(value);
            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, int value) {
        if (size == 0 || index > size - 1 || index < 0) {
            throw new IllegalArgumentException();
        }
        int currentIndex;
        Node temp;
        if (index == 0) {
            temp = head;
            Node newNode = new Node(value);
            head = newNode;
            newNode.next = temp;
            temp.prev = newNode;
        } else if (index == size - 1) {
            temp = tail;
            Node newNode = new Node(value);
            tail = newNode;
            temp.next = newNode;
        } else if (index < size / 2) {
            currentIndex = 0;
            temp = head;
            while (temp.next != null) {
                if (currentIndex == index - 1) {
                    Node newNode = new Node(value);
                    newNode.prev = temp;
                    newNode.next = temp.next;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                    break;
                } else {
                    temp = temp.next;
                    currentIndex++;
                }
            }
        } else {
            currentIndex = size - 1;
            temp = tail;
            while (temp.prev != null) {
                if (currentIndex == index + 1) {
                    Node newNode = new Node(value);
                    newNode.prev = temp.prev;
                    newNode.next = temp;
                    temp.prev.next = newNode;
                    temp.prev = newNode;
                    break;
                } else {
                    temp = temp.prev;
                    temp = temp.prev;
                    temp = temp.prev;
                    currentIndex--;
                }
            }
        }
        size++;
    }

    public int get(int index) {
        int currentIndex;
        Node temp;

        if (index < size / 2) {
            currentIndex = 0;
            temp = head;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.value;
                } else {
                    temp = temp.next;
                    currentIndex++;
                }
            }
        } else {
            currentIndex = size - 1;
            temp = tail;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.value;
                } else {
                    temp = temp.prev;
                    currentIndex--;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public int search(int value) {
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return currentIndex;
            } else {
                temp = temp.next;
                currentIndex++;
            }
        }
        return -1;
    }

    public boolean replace(int index, int value) {
        int currentIndex;
        Node temp;

        if (index < size / 2) {
            currentIndex = 0;
            temp = head;
            while (temp != null) {
                if (currentIndex == index) {
                    temp.value = value;
                    return true;
                } else {
                    temp = temp.next;
                    currentIndex++;
                }
            }
        } else {
            currentIndex = size - 1;
            temp = tail;
            while (temp != null) {
                if (currentIndex == index) {
                    temp.value = value;
                    return true;
                } else {
                    temp = temp.prev;
                    currentIndex--;
                }
            }
        }
        return false;
    }

    public void remove(int index) {
        if (size == 0 || index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        int currentIndex;
        Node temp;
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = head.prev;
        } else if (index < size / 2) {
            temp = head;
            currentIndex = 0;
            while (temp.next != null) {
                if (currentIndex == index - 1) {
                    temp.next.next.prev = temp;
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                    currentIndex++;
                }
            }
        } else {
            temp = tail;
            currentIndex = size - 1;
            while (temp.prev != null) {
                if (currentIndex == index + 1) {
                    temp.prev.prev.next = temp;
                    temp.prev = temp.prev.prev;
                    break;
                } else {
                    temp = temp.prev;
                    currentIndex--;
                }
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        int[] elements = new int[size];
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            elements[currentIndex++] = temp.value;
            temp = temp.next;
        }
        return Arrays.toString(elements);
    }

    private static class Node {

        private Node next;
        private Node prev;
        private int value;

        private Node(int value) {
            this.value = value;
        }
    }
}