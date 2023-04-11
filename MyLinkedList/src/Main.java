public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
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

        boolean isReplaced = list.replace(0, 20);
        System.out.println("Replace element with index 0");
        System.out.println("List : " + list);
        System.out.println("Is Replaced : " + isReplaced);
        System.out.println("Size : " + list.size() + "\n");

        list.remove(3);
        System.out.println("Remove element with index 3");
        System.out.println("List : " + list);
        System.out.println("Size : " + list.size());
    }
}
