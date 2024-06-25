public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead, end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode pre = start.next;
            ListNode next = end.next;
            end.next = null;

            start.next = reverse(pre);
            pre.next = next;

            start = pre;
            end = pre;
        }

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode curNode = head;
            head = head.next;
            curNode.next = last;
            last = curNode;
        }

        return last;
    }
}
