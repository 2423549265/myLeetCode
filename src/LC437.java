import java.util.HashMap;
import java.util.Map;

public class LC437 {
    Map<Long, Integer> prefixMap = new HashMap<>();
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        prefixMap.put(0L, 1); // 考虑任何节点可能等于 targetSum 的情况
        return dfs(root, 0);
    }

    int dfs(TreeNode root, long curSum) {
        if(root == null) return 0;

        int res = 0;
        curSum += root.val;

        res += prefixMap.getOrDefault(curSum - target, 0); // 累加之前的结果
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1); // 更新 map

        int left = dfs(root.left, curSum);
        int right = dfs(root.right, curSum);

        res += left + right;

        prefixMap.put(curSum, prefixMap.get(curSum) - 1); // 当前求的 curSum 只对其子节点有效

        return res;
    }
}
