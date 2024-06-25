public class LC416 {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }

        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i++)
            sum += nums[i];
        if(sum % 2 != 0)
            return false;
        sum /= 2;

        // dp[i][j]表示前i个元素是否能凑出和为j的子集
        boolean[][] dp = new boolean[len][sum + 1];
        dp[0][0] = true;
//        if (nums[0] < sum + 1) {
//            dp[0][nums[0]] = true;
//        }

        for(int i = 1; i < len; i++){
            for(int j = 0; j < sum + 1; j++){
                if(j == 0){
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] > j){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if(dp[i][sum])
                return true;
        }

        return dp[len - 1][sum];
    }
}
