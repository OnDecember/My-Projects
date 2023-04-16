import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private int defaultSize = 10;
    private Object[] list = new Object[defaultSize];

    public MyArrayList() {
    }

    public MyArrayList(int size) {
        this.defaultSize = size;
    }

    public void add(E element) {
        if (size == list.length) {
            grow(size);
        }
        list[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        if (size == list.length) {
            grow(size);
        }
        list = insert(list, index, 1);
        list[index] = element;
        size++;
    }

    public void addAll(E... elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public void addAll(int index, E... elements) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        if (size == list.length) {
            grow(size);
        }
        int length = elements.length;
        list = insert(list, index, length);
        for (int i = 0; i < length; i++) {
            list[index + i] = elements[i];
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        return (E) list[index];
    }

    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        list[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        list = delete(list, index);
        size--;
    }

    public boolean remove(E element) {
        int index = search(element);
        if (index != -1) {
            list = delete(list, index);
            size--;
            return true;
        }
        return false;
    }

    private void grow(int size) {
        list = Arrays.copyOf(list, (int) (size * 1.5 + 1));
    }

    private Object[] insert(Object[] array, int index, int countElements) {
        Object[] copy = new Object[array.length + countElements];
        System.arraycopy(array, 0, copy, 0, index);
        System.arraycopy(array, index, copy, index + countElements, array.length - index);
        return copy;
    }

    private Object[] delete(Object[] array, int index) {
        Object[] copy = new Object[array.length - 1];
        System.arraycopy(array, 0, copy, 0, index);
        System.arraycopy(array, index + 1, copy, index, copy.length - index);
        return copy;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        list = new Object[defaultSize];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}