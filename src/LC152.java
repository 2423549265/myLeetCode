public class LC152 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int num : nums) {
            int curMax = Math.max(Math.max(num * max, num * min), num);
            int curMin = Math.min(Math.min(num * max, num * min), num);
            result = Math.max(result, curMax);
            max = curMax;
            min = curMin;
        }
        return result;
    }
}
