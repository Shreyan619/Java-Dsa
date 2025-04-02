
import java.util.Stack;

// 907. Sum of Subarray Minimums
public class lc907 {

    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7;
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            // number of elements to the left (including current) where arr[i] is the minimum.
            long left1 = i - left[i];
            // number of elements to the right (including current) where arr[i] is the minimum.
            long right2 = right[i] - i;
            //sum is the appearance of minimum in each subarrays
            sum = (sum + (arr[i] * left1 * right2) % MOD) % MOD;
        }
        return (int) sum;
    }

}
