// 1690. Stone Game VII

public class lc877 {

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int dp[][] = new int[n][n];
        // When i == j, Alice picks the only pile available, so the value is just piles[i].
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(
                        piles[i] - dp[i + 1][j], // Pick leftmost stone
                        piles[j] - dp[i][j - 1] // Pick rightmost stone
                );
            }
        }
        return dp[0][n - 1] > 0;

    }

    // optimized O(n)
    private boolean stoneGame(int[] piles) {

        int n = piles.length;
        int dp[] = new int[n];
        // When i == j, Alice picks the only pile available, so the value is just piles[i].
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i] = Math.max(
                        piles[i] - dp[i + 1], // Pick leftmost stone
                        piles[i] - dp[j - 1] // Pick rightmost stone
                );
            }
        }
        return dp[0] > 0;

    }
}
