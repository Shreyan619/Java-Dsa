//lc 206 nd lc 92

public class lc206 {

    ListNode head;
    private int size;

    public lc206() {
        this.size = 0;
    }

    class ListNode {

        int val;
        ListNode next;

        public ListNode() { // Default constructor
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    void insert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println("val : " + temp.val);
            temp = temp.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return rev;
    }

    //lc92 reverse linked list 2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //move a pointer (prev) to the node just before the leftth node.
        ListNode prev = dummy;
        for (int i = 0; prev != null && i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode current = prev.next; //current: Points to the first node to be reversed (leftth node).
        ListNode temp = null;//Temporarily stores the next node to maintain the connection during reversal.

        for (int i = 0; current != null && current.next != null && i < right - left; i++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        lc206 list = new lc206();

        // Insert nodes
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Display original list
        System.out.println("Original List:");
        list.display();

        // Reverse the list using recursion
        list.head = list.reverse(list.head);

        // Display reversed list
        System.out.println("Reversed List:");
        list.display();
    }
}
