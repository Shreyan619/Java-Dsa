
public class segmentTree {

    public static class Node {

        int startInterval;
        int endInterval;
        int data; // This field stores the value or aggregate information for the segment
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    private Node root;

    public segmentTree(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }

        System.out.println("Interval: [" + node.startInterval + ", " + node.endInterval + "] -> Data: " + node.data);
        display(node.left);
        display(node.right);
    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei); //qsi=query start index, qei=query end index
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // node is completely lying inside query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // node is completely outside query
            return 0;
            //completely outside
        } else {
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};

        // Create a segment tree
        segmentTree tree = new segmentTree(arr);

        // Display the segment tree
        // System.out.println("Displaying the segment tree:");
        tree.display();
        System.out.println();
        // System.out.println(tree.query(1, 6));
        tree.update(3, 10);
        System.out.println();
        tree.display();
    }
}
