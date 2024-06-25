public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = last;
            last = cur;
        }

        return last;
    }
}
