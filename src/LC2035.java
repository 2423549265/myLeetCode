public class LC2035 {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= sum; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] = dp[i - num];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }

        for (int i = sum / 2; i <= sum; i++) {
            if (dp[i]) {
                return 2 * (i - sum / 2);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LC2035 lc2035 = new LC2035();
        System.out.println(lc2035.minimumDifference(new int[]{3,9,7,3}));
    }
}
