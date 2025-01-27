
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc637 {

    public static class TreeNode {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            double avg = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentlvl = q.poll();
                avg += currentlvl.val;
                if (currentlvl.left != null) {
                    q.offer(currentlvl.left);
                }
                if (currentlvl.right != null) {
                    q.offer(currentlvl.right);
                }
            }
            avg = avg / levelSize;
            res.add(avg);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        lc637 solution = new lc637();
        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result);
    }
}
