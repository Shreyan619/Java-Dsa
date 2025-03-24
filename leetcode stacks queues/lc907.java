// 907. Sum of Subarray Minimums

public class lc907 {

    public int sumSubarrayMins(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // int dp[] = new int[n];
        int sum = 0;

        return sum;

    }

    private int getSub(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {

            }
            stack.push(i);
        }
    }
}
