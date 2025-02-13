
public class frogJump {

    // private int dp[];
    // private int index;
    int minCost(int[] height) {
        int n = height.length;
        int dp[] = new int[n];
        dp[0] = -1;
        return helper(n - 1, height, dp);

    }
//recursion

    private int helper(int index, int[] height, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int left = helper(index - 1, height, dp) + Math.abs(height[index] - height[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = helper(index - 2, height, dp) + Math.abs(height[index] - height[index - 2]);
        }
        return dp[index] = Math.min(left, right);
    }

    // memoization
    private int helper2(int index, int[] height, int[] dp) {
        dp[0] = 0;
        for (int i = 0; i < height.length; i++) {
            int left = helper2(index - 1, height, dp) + Math.abs(height[index] - height[index - 1]);
            int right = Integer.MAX_VALUE;
            if (index > 1) {
                right = helper2(index - 2, height, dp) + Math.abs(height[index] - height[index - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[height.length - 1];
    }

    //space optimization
    private int helper3(int[] height) {
        int n = height.length;
        int prev2 = 0, prev = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(height[i] - height[i - 1]);
            int right = (i > 1) ? prev2 + Math.abs(height[i] - height[i - 2]) : Integer.MAX_VALUE;

            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev; // prev holds the minimum energy required
    }
}
