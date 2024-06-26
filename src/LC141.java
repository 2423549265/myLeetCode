public class LC141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
    }
}
