public class LC24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head, slow = dummyNode;

        while (fast != null && fast.next != null) {
            ListNode next = fast.next;
            slow.next = next;
            fast.next = next.next;
            next.next = fast;

            fast = fast.next;
            slow = slow.next.next;
        }

        return dummyNode.next;
    }
}
