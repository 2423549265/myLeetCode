public class LC11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int curHeight = 0;
            if (height[left] <= height[right]) {
                curHeight = height[left++];
            } else {
                curHeight = height[right--];
            }
            int curArea = curHeight * (right - left + 1);
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
