// 124.max path sum

public class lc124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, helper(node.left));
        int rightSum = Math.max(0, helper(node.right));

        int sum = node.val + leftSum + rightSum;
        ans = Math.max(sum, ans);

        return node.val + Math.max(leftSum, rightSum);
    }
}
