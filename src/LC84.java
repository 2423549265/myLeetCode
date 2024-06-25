import java.util.ArrayDeque;
import java.util.Deque;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        // 单调递增栈，用于寻找左边第一个比当前柱子低的柱子
        Deque<Integer> stack = new ArrayDeque<>();
        // 加入哨兵，减少特判
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                Integer curIndex = stack.pop();
                // 计算curIndex的柱子为最大高度的矩阵面积
                maxArea = Math.max(maxArea, heights[curIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            Integer curIndex = stack.pop();
            maxArea = Math.max(maxArea, heights[curIndex] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }
}
