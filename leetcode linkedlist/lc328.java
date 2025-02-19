// 328. Odd Even Linked List

public class lc328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
    }
    // [1,2,3,4,5]
}
