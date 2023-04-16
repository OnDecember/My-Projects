import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        List<Integer> list1 = new ArrayList<>();

        System.out.println("Create List");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("Add new elements");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        list.add(1, 15);
        System.out.println("Add new element to the list with index 1");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        System.out.println("Get element with index 1");
        System.out.println("List : " + list);
        System.out.println("Element : " + list.get(1));
        System.out.println("Size : " + list.size() + "\n");

        System.out.println("Search element with value 3");
        System.out.println("List : " + list);
        System.out.println("Index : " + list.search(3));
        System.out.println("Size : " + list.size() + "\n");

        list.set(0, 20);
        System.out.println("Replace element with index 0");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        list.remove(3);
        System.out.println("Remove element with index 3");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        boolean isRemove = list.remove(Integer.valueOf(3));
        System.out.println("Remove element with value 3");
        System.out.println("List : " + list);
        System.out.println("Is Remove : " + isRemove);
        System.out.println("Size : " + list.size() + "\n");

        boolean isEmpty = list.isEmpty();
        System.out.println("Check list for emptiness");
        System.out.println("List : " + list);
        System.out.println("Is Empty : " + isEmpty);
        System.out.println("Size : " + list.size() + "\n");

        list.addAll(new Integer[]{10, 20, 30});
        System.out.println("Add new elements to the list");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        list.addAll(0, new Integer[]{1, 2, 3});
        System.out.println("Add new elements to the list with index 0");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size() + "\n");

        list.clear();
        System.out.println("Clear list");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size());
    }
}