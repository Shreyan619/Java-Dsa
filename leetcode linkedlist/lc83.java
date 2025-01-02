//remove duplicates

public class lc83 {

    Node head;
    private int size;

    public lc83() {
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

    public void duplicates() {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                // size--;
            } else {
                node = node.next;
            }
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        lc83 list = new lc83();
        list.insert(20);
        list.insert(30);
        list.insert(30);
        list.insert(40);
        list.insert(40);
        list.display();
        list.duplicates();
        list.display();
    }
}
