//merge 2 sorted ll

public class lc21 {

    Node head;
    private int size;

    public lc21() {
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

    // Insert a node at the end of the list
    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Merge two sorted linked lists
    public static lc21 mergeLL(lc21 list1, lc21 list2) {
        lc21 temp = new lc21();
        Node f = list1.head;
        Node s = list2.head;

        // Traverse both lists and insert values in sorted order
        while (f != null && s != null) {
            if (f.val <= s.val) {
                temp.insert(f.val);
                f = f.next;
            } else {
                temp.insert(s.val);
                s = s.next;
            }
        }

        // Add remaining elements from list1
        while (f != null) {
            temp.insert(f.val);
            f = f.next;
        }

        // Add remaining elements from list2
        while (s != null) {
            temp.insert(s.val);
            s = s.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        lc21 list1 = new lc21();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        lc21 list2 = new lc21();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        System.out.println("List 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        lc21 mergedList = mergeLL(list1, list2);

        System.out.println("Merged List:");
        mergedList.display();
    }
}
