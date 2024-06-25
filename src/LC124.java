public class LC124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left + right + root.val);

        int child = Math.max(left, right);
        if (child < 0) {
            return Math.max(root.val, 0);
        } else {
            return Math.max(root.val + child, 0);
        }
    }
}
