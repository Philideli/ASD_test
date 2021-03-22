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

        /*CircledList<Integer> list = CircledList.of(1, 3, 5, 6, 7, 8);
        System.out.println("Size: " + list.size() + "; values: " + list);
        for (int index = 0; index < 10; index++) {
            list.addFirst(index + 1);
            list.addLast(index * 2);
            list.add(index / 2);
        }
        System.out.println("Size: " + list.size() + "; values: " + list);
        list.clear();
        System.out.println("Size: " + list.size() + "; values: " + list);

        list = CircledList.of(2, 3, 4, 5, 8, 3, null, 3, 4);

        System.out.println("Size: " + list.size() + "; values: " + list);
        System.out.println("Contains [3] : " + list.contains(3));
        //System.out.println("Contains [10]: " + list.contains(10)); //exception

        System.out.println("IndexOf(2) : " + list.indexOf(2));
        System.out.println("IndexOf(8) : " + list.indexOf(8));
        //System.out.println("IndexOf(10): " + list.indexOf(10)); //exception

        System.out.println("Get(5): " + list.get(5));
        System.out.println("Get(7): " + list.get(7));
        System.out.println("Get(6): " + list.get(6));

        System.out.println("Get(0): " + list.get(0));
        System.out.println("Get(2): " + list.get(2));
        System.out.println("Get(4): " + list.get(4));

        list.clear();

        list.add(1);
        System.out.println("Size: " + list.size() + "; values: " + list);
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());

        list.addAll(2, 3);
        System.out.println("Size: " + list.size() + "; values: " + list);
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());

        list.addAll(2, 3, 4);
        System.out.println("Size: " + list.size() + "; values: " + list);
        list.add(0, 9);
        list.add(list.size() - 1, 9);
        list.add(5, 9);
        System.out.println("Size: " + list.size() + "; values: " + list);

        list.replace(0, 7);
        list.replace(list.size() - 1, 7);
        list.replace(3, 7);
        System.out.println("Size: " + list.size() + "; values: " + list);

        System.out.println("lastIndexOf(7): " + list.lastIndexOf(7));
        System.out.println("lastIndexOf(2): " + list.lastIndexOf(2));
        System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
        System.out.println("lastIndexOf(9): " + list.lastIndexOf(9));

        list.clear();
        list.add(0, 1);
        System.out.println("Size: " + list.size() + "; values: " + list);
        System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
        System.out.println("indexOf(1): " + list.indexOf(1));
        list.add(0, 2);
        System.out.println("Size: " + list.size() + "; values: " + list);
        System.out.println("lastIndexOf(1): " + list.lastIndexOf(1));
        System.out.println("indexOf(2): " + list.indexOf(2));

        list.addAll(1, 2, 3);
        System.out.println("Size: " + list.size() + "; values: " + list);
        list.removeLast();
        System.out.println("removeLast() : " + "; list: " + list);
        list.removeLast();
        System.out.println("removeLast() : " + "; list: " + list);
        list.removeFirst();
        System.out.println("removeFirst() : " + "; list: " + list);
        list.removeFirst();
        System.out.println("removeFirst() : " + "; list: " + list);
        list.removeFirst();
        System.out.println("removeFirst() : " + "; list: " + list);

        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(0, 4);
        list.add(0, 5);
        System.out.println("Size: " + list.size() + "; values: " + list);

        list.remove(0);
        System.out.println("remove(0): " + "; list: " + list);
        list.remove(1);
        System.out.println("remove(0): " + "; list: " + list);
        list.remove(2);
        System.out.println("remove(0): " + "; list: " + list);
        list.remove(0);
        System.out.println("remove(0): " + "; list: " + list);

        list.addAll(1, 2, 3, 4, 5);
        System.out.println("Size: " + list.size() + "; values: " + list);

        System.out.println();
        list.removeLast();
        list.removeFirst();
        list.remove(0);
        list.remove(0);
        list.remove(0);

        System.out.println("Size: " + list.size() + "; values: " + list);


        list.addAll(1, 2, 3, 4, 5, 6);
        System.out.println("Size: " + list.size() + "; values: " + list);

        System.out.println("Sum: " + list.sum());*/
    }
}
