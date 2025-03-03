//lc1690.stone game 7

public class lc1690 {

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int sum[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        int dp[] = new int[n];  //stores the maximum difference in score Alice can obtain over Bob from index i to j
        //so dp array is bobs turn
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                int leftSum = sum[j + 1] - sum[i + 1] - dp[i + 1];
                int rightSum = sum[j] - sum[i] - dp[i];
                dp[i] = Math.max(leftSum, rightSum);
            }
        }
        return dp[0];
    }
}
