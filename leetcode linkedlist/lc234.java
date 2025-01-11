//palindrome list

public class lc234 {

    ListNode head;
    private int size;

    public lc234() {
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

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode headSecondHalf = reverse(mid);
        ListNode temp = headSecondHalf;

        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                reverse(temp);
                return false;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        reverse(temp);
        return true;
    }

    public ListNode getMid(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverse(head.next);
        ListNode front = head;
        front.next = head;
        head.next = null;
        return rev;
    }
}
