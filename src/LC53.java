public class LC53 {
    public int maxSubArray(int[] nums) {
        int minPreSum = 0;
        int result = Integer.MIN_VALUE;
        int curPreSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            result = Math.max(result, curPreSum - minPreSum);
            minPreSum = Math.min(minPreSum, curPreSum);
        }

        return result;
    }
}
