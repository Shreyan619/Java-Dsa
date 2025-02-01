
public class pathExist {

    boolean findPath(Node node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }
        return helper(node, arr, 0);
    }

    private boolean helper(Node node, int[] arr, int index) {
        if (node == null) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        // Define an array representing the path
        int[] arr = {5, 3, 4, 7};

        // Create an instance of pathExist and check if the path exists
        pathExist solution = new pathExist();
        boolean result = solution.findPath(root, arr);
        System.out.println("Path exists: " + result);
    }
}

class Node {

    int val;
    Node left, right;

    Node(int x) {
        val = x;
    }
}
