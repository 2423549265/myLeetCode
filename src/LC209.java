public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            right ++;
            while (sum >= target) {
                len = Math.min(right - left, len);
                sum -= nums[left];
                left ++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
