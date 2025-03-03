// 1770. Maximum Score from Performing Multiplication Operations

public class lc1770 {

    private Integer dp[][];

    public int maximumScore(int[] nums, int[] multipliers) {
        int left = 0, max = 0, prod = 1;
        int m = multipliers.length;
        int n = nums.length;
        dp = new Integer[m][m];
        return helper(0, 0, nums, multipliers);
    }

    private int helper(int left, int i, int[] nums, int[] mul) {
        if (i == mul.length) {
            return 0;
        }
        if (dp[left][i] != null) {
            return dp[left][i];
        }
        int right = nums.length - (i - left) - 1;
        int pickleft = mul[i] * nums[left] + helper(left + 1, i + 1, nums, mul);
        int pickright = mul[i] * nums[right] + helper(left, i + 1, nums, mul);
        int max = Math.max(pickleft, pickright);
        return dp[left][i] = max;
    }
}
