import java.util.HashMap;

public class LC146 {
    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {

        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private int size;

    private HashMap<Integer, LinkedNode> map = new HashMap<>();

    private LinkedNode head;

    private LinkedNode tail;

    public LC146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode linkedNode = map.get(key);
        if (linkedNode == null) {
            return -1;
        }

        // 处理前后节点的连接
        LinkedNode preNode = linkedNode.pre;
        LinkedNode nextNode = linkedNode.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;

        // 将当前节点放置在链表头部
        LinkedNode next = head.next;
        head.next = linkedNode;
        linkedNode.pre = head;
        linkedNode.next = next;
        next.pre = linkedNode;

        return linkedNode.value;
    }

    public void put(int key, int value) {
        LinkedNode curNode;
        if (map.containsKey(key)) {
            // 当前值已经存在，不需要增加size，更新当前value
            curNode = map.get(key);
            curNode.value = value;
            LinkedNode preNode = curNode.pre;
            LinkedNode nextNode = curNode.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        } else {
            curNode = new LinkedNode(key, value);
            map.put(key, curNode);
            // 检查容量
            if (++size > capacity) {
                // 需要删除尾部节点
                LinkedNode delNode = tail.pre;
                LinkedNode preNode = delNode.pre;
                preNode.next = tail;
                tail.pre = preNode;
                delNode.next = null;
                delNode.pre = null;
                map.remove(delNode.key, delNode);
            }
        }

        // 插入到链表头部
        LinkedNode next = head.next;
        head.next = curNode;
        curNode.pre = head;
        curNode.next = next;
        next.pre = curNode;
    }
}
