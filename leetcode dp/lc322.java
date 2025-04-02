
import java.util.Arrays;

public class lc322 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // If dp[i - coin] is Integer.MAX_VALUE, it means there's no valid combination to make that sub-amount, so you can't add this coin to it.
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    // dp[i - coin] + 1 represents the number of coins needed to make amount i - coin, plus this current coin.
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
