import java.util.HashMap;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, indexMap);
    }

    private TreeNode build(int[] preorder, int preLow, int preHigh, int inLow, HashMap<Integer,Integer> indexMap) {
        if (preHigh < preLow) {
            return null;
        }

        int rootValue = preorder[preLow];
        int index = indexMap.get(rootValue);

        TreeNode left = build(preorder, preLow + 1, preLow + index - inLow, inLow, indexMap);
        TreeNode right = build(preorder, preLow + 1 + index - inLow, preHigh, index + 1, indexMap);

        return new TreeNode(rootValue, left, right);
    }
}
