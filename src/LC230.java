public class LC230 {
    int index = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);

        index++;
        if (index == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
