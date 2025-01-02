
public class insertusingRecursion {

    Node head;
    private int size;

    public insertusingRecursion() {
        this.size = 0;
    }

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;

        }
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public void insertAtPosi(int val, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        head = insert(val, index, head);
    }

    private Node insert(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val);
            temp.next = node;
            size++;
            return temp;
        }
        // Recursive case: Move to the next node, decreasing the position
        node.next = insert(val, index - 1, node.next);
        return node;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        insertusingRecursion list = new insertusingRecursion();
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();
        list.insertAtPosi(25, 2);
        list.display();
    }
}
