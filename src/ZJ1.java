public class ZJ1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // 使用 dummy 节点简化边界情况处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev_left = dummy;

        // 找到第 left 个节点的前一个节点
        for (int i = 1; i < left; i++) {
            prev_left = prev_left.next;
        }

        // 开始反转链表节点，从第 left 个节点到第 right 个节点
        ListNode curr = prev_left.next;
        ListNode prev = null;
        ListNode right_node = null;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if (i == right) {
                right_node = curr;
            }
        }

        // 连接反转部分与原链表
        prev_left.next.next = curr;
        prev_left.next = prev;

        return dummy.next;
    }
}
