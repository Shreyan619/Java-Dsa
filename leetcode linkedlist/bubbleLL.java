
public class bubbleLL {

    ListNode head;

    // Nested ListNode class
    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
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

    void bubble() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swap;
        do {
            swap = false;
            ListNode current = head; // tracks the node that is being compared with its next node.
            ListNode prev = null; // helps to update the link of the previous node when a swap is needed.
            while (current != null && current.next != null) {
                if (current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                    swap = true;
                }
                prev = current;
                current = current.next;
            }
        } while (swap);

    }

    public static void main(String[] args) {
        bubbleLL list = new bubbleLL();

        // Insert elements into the list
        list.insert(4);
        list.insert(2);
        list.insert(1);
        list.insert(3);

        System.out.println("Original list:");
        list.display();

        // Perform bubble sort
        list.bubble();

        System.out.println("Sorted list:");
        list.display();
    }
}
