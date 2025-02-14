// house robber2

public class lc213 {

    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        if (start == end) {
            return nums[0];
        }
        int prev2 = 0, prev = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev, prev2 + nums[i]);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    private int sc(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        int up = sc(i - 1, j);
        int left = sc(i, j - 1);
        return up + left;
    }
}
