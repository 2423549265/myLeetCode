import java.util.ArrayDeque;
import java.util.Deque;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peekLast()) {
                stack.pollLast();
            }
            stack.offer(nums[i]);
        }
        result[0] = stack.peekFirst();
        for (int i = k; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peekLast()) {
                stack.pollLast();
            }
            stack.offer(nums[i]);
            if (nums[i - k] == stack.peekFirst()) {
                stack.pollFirst();
            }
            result[i - k + 1] = stack.peekFirst();
        }

        return result;
    }
}
