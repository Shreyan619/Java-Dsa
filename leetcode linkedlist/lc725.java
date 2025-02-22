//split ll into parts

public class lc725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        int n = 0;
        while (curr != null) { // traverse and get length
            curr = curr.next;
            n += 1;
        }

        int partSize = n / k; // min size of each part
        int extraNodes = n % k; // nodes remain after split
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            int currPartSize = partSize + (i < extraNodes ? 1 : 0);

            // Stopping at currPartSize - 1 ensures we can properly break the link.
            for (int j = 0; j < currPartSize - 1 && curr != null; j++) {
                curr = curr.next;

            }
            if (curr != null) {
                ListNode nextPartHead = curr.next;
                curr.next = null;
                curr = nextPartHead;
            }
            res[i] = partHead;
        }
        return res;
    }
}
