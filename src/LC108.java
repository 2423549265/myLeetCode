public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode leftTree = buildBST(nums, left, mid - 1);
        TreeNode rightTree = buildBST(nums, mid + 1, right);
        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = leftTree;
        rootNode.right = rightTree;

        return rootNode;
    }
}
