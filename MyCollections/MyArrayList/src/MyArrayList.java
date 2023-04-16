import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private final int DEFAULT_SIZE = 10;
    private Object[] list = new Object[DEFAULT_SIZE];

    public void add(E element) {
        if (size == list.length) {
            grow(size);
        }
        list[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index : " + index + ", expected index between 0 and " + size);
        }
        if (size == list.length) {
            grow(size);
        }
        list = insert(list, index);
        list[index] = element;
        size++;
    }

    private void grow(int size) {
        list = Arrays.copyOf(list, (int) (size * 1.5 + 1));
    }

    private Object[] insert(Object[] array, int index) {
        Object[] copy = new Object[array.length + 1];
        System.arraycopy(array, 0, copy, 0, index);
        System.arraycopy(array, index, copy, index + 1, array.length - index);
        return copy;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
