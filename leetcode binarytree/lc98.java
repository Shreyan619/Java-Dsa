// 98. Validate Binary Search Tree

public class lc98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // int is a primitive type in Java, and it cannot be null. It always has a default value of 0 when it is not explicitly initialized.
    // Integer is the wrapper class for the int primitive, and it is an object. As an object, it can be null
    private boolean isValidBST(TreeNode Node, Integer low, Integer high) {
        if (Node == null) {
            return true;
        }
        if (low != null && Node.val <= low) {
            return false;
        }
        if (high != null && Node.val >= high) {
            return false;
        }
        boolean leftTree = isValidBST(Node.left, low, Node.val);
        boolean rightTree = isValidBST(Node.right, Node.val, high);

        return leftTree && rightTree;
    }
}
