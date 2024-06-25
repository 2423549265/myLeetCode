public class Package {
    public void search(int[] weight, int[] value, int bagSize) {
        // dp[i][j]表示从前i个物品里任取放入容量为j的背包所产生的最大价值
        int[][] dp = new int[weight.length][bagSize + 1];

        // 初始化
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    // 背包中无法放入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 背包中放i与不放i取最大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[weight.length - 1][bagSize]);
    }
}
