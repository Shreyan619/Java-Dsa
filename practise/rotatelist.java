
public class rotatelist {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        int rotate = k % len;
        for (int i = 0; i < rotate; i++) {
            ListNode last = head, prev = null;
            while (last.next != null) {
                last = last.next;
                prev = last;
            }
            last.next = head;
            prev.next = null;
            head = last;
        }
        return head;
    }
}
