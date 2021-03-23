import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SparseList<Integer> list = new SparseList<>();
        list.set(1,9);
        System.out.println(list.toString());
        list.set(3, 4);
        System.out.println(list.toString());
        list.set(9, 4);
        System.out.println(list.toString());
        list.get(5);
        System.out.println(list.toString());
        list.remove(4);
        System.out.println(list.toString());
        System.out.println(list.get(8));
        System.out.println(list.get(1));

        System.out.println(list.toString());
        list.sort_nonempty();
        System.out.println(list.toString());


        System.out.println("------------------Бонусне завдання (реалізація на Linked List)------------------------");

        SparseLinkedList<Integer> list1 = new SparseLinkedList<>();
        list1.set(1,9);
        System.out.println(list1.toString());
        list1.set(3, 4);
        System.out.println(list1.toString());
        list1.set(9, 4);
        System.out.println(list1.toString());
        list1.get(5);
        System.out.println(list1.toString());
        list1.remove(4);
        System.out.println(list1.toString());
        System.out.println(list1.get(8));
        System.out.println(list1.get(1));

        System.out.println(list1.toString());
        list1.sort_nonempty();
        System.out.println(list1.toString());

    }
}
