import java.util.PriorityQueue;
import java.util.Queue;

public class LC295 {
    Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    Queue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public LC295() {

    }

    public void addNum(int num) {
        if (maxQueue.size() != minQueue.size()) {
            maxQueue.offer(num);
        } else {
            minQueue.offer(num);
        }

        if (!maxQueue.isEmpty() && minQueue.peek() > maxQueue.peek()) {
            maxQueue.offer(minQueue.poll());
            minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.size() != minQueue.size()) {
            return minQueue.peek();
        } else {
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
    }
}
