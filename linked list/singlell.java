
public class singlell {

    Node head;
    private int size;

    public static void main(String[] args) {
        singlell list = new singlell();
        list.insert1st(2);
        list.insert1st(4);
        list.insert1st(5);
        list.insert1st(6);
        list.insert1st(7);
        list.insert1st(8);
        list.display();
        Node middle = list.middleNode(list.head);
        System.out.println("Middle node value: " + middle.val);
    }

    public void insert1st(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    //lc846 middle of ll
    void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("end");
    }

    class Node {

        Node next;
        Node prev;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, Node prev, int val) {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }

    }
}
