import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class PerfectList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 小紫的完美链表，一个链表是完美的，当且仅当链表上所有节点的数字相等，现在有一个链表需要删除一些节点变成完美链表，希望删除的节点数量尽可能少
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode solve (ListNode head) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int maxCnt = 0;
        int maxVal = -1;
        // 统计数量最多的节点值
        for (ListNode cur = head; cur != null; cur = cur.next) {
            int cnt = cntMap.getOrDefault(cur.val, 0);
            cnt ++;
            maxCnt = Math.max(maxCnt, cnt);
            if (maxCnt == cnt) {
                maxVal = cur.val;
            }
            cntMap.put(cur.val, cnt);
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        while (cur != null) {
            if (cur.val != maxVal) {
                // 需要删除
                ListNode next = cur.next;
                pre.next = next;
                cur = next;
                continue;
            }
            pre = pre.next;
            cur = cur.next;
        }
        // write code here
        return dummyHead.next;
    }
}
