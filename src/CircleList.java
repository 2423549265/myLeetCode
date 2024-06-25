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

public class CircleList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 循环节链表为[1,2]，额外循环次数为2，则原链表为[1,2,1,2,1,2]，输入为作为循环节的链表和额外循环次数k，输出需要还原这个链表
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode copyList (ListNode head, int k) {
        // write code here
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        for (int i = 0; i < k; i++) {
            for (ListNode cur = head; cur != null; cur = cur.next) {
                ListNode newNode = new ListNode(cur.val);
                tail.next = newNode;
                tail = newNode;
            }
        }

        return dummyHead.next;
    }
}