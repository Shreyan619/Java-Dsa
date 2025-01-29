// 543. Diameter of Binary Tree

public class lc543 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int Diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return Diameter-1;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHt = height(node.left);
        int rightHt = height(node.right);
        int dia = leftHt + rightHt + 1;
        Diameter = Math.max(Diameter, dia);

        return Math.max(leftHt, rightHt) + 1;
    }
}
