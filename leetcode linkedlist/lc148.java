//sortlist

public class lc148 {

    ListNode head;
    private int size;

    public lc148() {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // break ll into 2 halves
        ListNode mid = middle(head);
        ListNode right = mid.next;
        mid.next = null;

        // The middle function only finds the middle but doesn't split the list.
        // This is why sortList was working with an unsplit list,
        // leading to incorrect results.
        //error was ListNode left=sortList(head); xxxxxxx
        ListNode lSort = sortList(head);
        ListNode rSort = sortList(right);

        return merge(lSort, rSort);

    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode main = new ListNode();
        ListNode temp = main;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 != null) ? l1 : l2;
        return main.next;
    }

    public ListNode middle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public static void main(String[] args) {
        lc148 list = new lc148();

        // Insert nodes into the list
        list.insert(4);
        list.insert(2);
        list.insert(1);
        list.insert(3);

        System.out.println("Original list:");
        list.display();

        // Sort the list
        list.head = list.sortList(list.head);

        System.out.println("Sorted list:");
        list.display();
    }
}
