import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!queue.isEmpty()) {
            ListNode pollNode = queue.poll();
            cur.next = pollNode;
            cur = pollNode;
            if (pollNode.next != null) {
                queue.offer(pollNode.next);
            }
        }

        return dummyHead.next;
    }
}
