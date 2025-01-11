
public class lc61 {

    ListNode head;

    // Nested ListNode class
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

    // Method to add a node at the end of the list
    void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the linked list
    void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int c = k;
        while (c > 0 && curr != null) { // 1sr rev
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c--;
        }

        if (curr == null && c > 0) { // re reverse the remaining
            curr = prev;
            prev = null;
            next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        if (c > 0) {
            return prev;// if last group size is not k, return the original
            // head of last sub list which will be in prev after reversing two times
        } else {
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        lc61 list = new lc61();

        // Insert elements into the list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);

        System.out.println("Original list:");
        list.display();

        // Perform bubble sort
        list.head = list.reverseKGroup(list.head, 3);

        System.out.println("Sorted list:");
        list.display();
    }
}
