// 129. Sum Root to Leaf Numbers

public class lc129 {

    private int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = sumNumbers(root.left, sum);
        int right = sumNumbers(root.right, sum);

        return left + right;
    }
}
