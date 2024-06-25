public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                curNode.next = list2;
                break;
            } else if (list2 == null) {
                curNode.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        return dummyHead.next;
    }
}
