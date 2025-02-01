// 230. Kth Smallest Element in a BST

public class lc230 {

    int count = 0;

    private TreeNode helper(TreeNode node, int k) {
        if (node == null) {
            return 0;
        }
        TreeNode left = helper(node.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return node;
        }
        return helper(node.right, k);
    }
}
