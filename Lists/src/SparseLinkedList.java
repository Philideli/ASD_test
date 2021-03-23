public class SparseLinkedList<Integer> implements List<Integer> {
    private Node first;
    private Node last;
    private int size;
    private int firstSp = 0;

    SparseLinkedList() {
    }

    //основні методи, що треба реалізувати


    @Override
    public void remove(int index) {
        if (size > 0){
            index -= firstSp;
            if (index < 0){
                firstSp--;
            }
            else if (index == 0){
                firstSp += first.space;
                Node node = first;
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }
            else{
                int j = 0;
                Node node = first;
                while (index > 0 && j <= size - 1){
                    index -= (node.space + 1);
                    node = node.next;
                    j++;
                }
                if (index < 0)
                {
                    node.prev.space--;
                }
                else if (index == 0){
                    node.prev.space += node.space;
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                }
            }
        }
    }

    @Override
    public Integer get(int index){
        if (this.size == 0)
        {
            Object tmp = 0;
            return (Integer) tmp;
        }
        index -= firstSp;
        if (index < 0){
            Object tmp = 0;
            return (Integer) tmp;
        }
        else if (index == 0){
            return (Integer) first.value;
        }
        else{
            int j = 0;
            Node node = first;
            while (index > 0 && j <= size - 2){
                index -= (node.space + 1);
                node = node.next;
                j++;
            }
            if (index != 0)
            {
                Object tmp = 0;
                return (Integer) tmp;
            }
            else {
                return (Integer) node.value;
            }
        }
    }

    @Override
    public void set(int index, Integer value) {
        if (size == 0) {
            this.first = new Node(value);
            this.first.prev = this.first.next = this.first;
            this.last = this.first;
            firstSp = index;
            size++;
        } else {
            index -= firstSp;
            if (index < 0){
                Node node = new Node(this.first, this.last, value, (-1)*index);
                this.last.next = this.first.prev = node;
                this.first = node;
                firstSp += index;
                size++;
            }
            else if (index == 0){
                first.value = value;
            }
            else{
                int j = 0;
                Node node = first;
                while (index > 0 && j <= size - 2) {
                    index -= (node.space + 1);
                    node = node.next;
                    j++;
                }
                if (index < 0){
                    Node tmp = new Node(node, node.prev, value, (-1)*index);
                    node.prev.space += index;
                    node.prev = tmp;
                    size++;
                }
                else if (index == 0){
                    node.value = value;
                }
                else {
                    Node tmp = new Node(node.next, node, value, 0);
                    node.next.prev = tmp;
                    node.next = tmp;
                    node.space = index - 1;
                    size++;
                }
            }
        }
    }


    @Override
    public void sort_nonempty(){
        if (!isEmpty()) {
            Node node = first.next;
            for (int j = 1; j <= size - 1; j++) {
                int key = (int) node.value;
                Integer k = node.value;
                int i = j - 1;
                node = node.prev;
                while (i >= 0 && (int) node.value > key) {
                    node.next.value = node.value;
                    node = node.prev;
                    i--;
                }
                node.next.value = k;
                while (i <= j){
                    node = node.next;
                    i++;
                }
            }
        }

    }

    //допоміжні методи

    private boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("{ ");
        Node node = this.first;
        for (int i = 0; i < firstSp;i++){
            str.append("0").append(" ");
        }
        int j = 0;
        while(j < size - 1)
        {
            str.append(node.value.toString()).append(" ");
            for (int i = 0; i < node.space;i++){
                str.append("0").append(" ");
            }
            node = node.next;
            j++;
        }
        str.append(node.value.toString());
        str.append(" }");
        return str.toString();
    }


    private class Node {
        private Node next;
        private Node prev;
        private Integer value;
        private int space;

        Node(Node next, Node prev, Integer value, int space) {
            this.next = next;
            this.prev = prev;
            this.value = value;
            this.space = space;
        }

        Node(Integer value) {
            this(null, null, value, 0);
        }

    }
}
