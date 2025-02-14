
import java.util.Arrays;

public class lc62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        // return recursion(m - 1, n - 1, dp);
        return tab(m, n, dp);
    }
//recursion

    private int recursion(int i, int j, int dp[][]) { // approach from the bottom
        if (i == 0 || j == 0) { //1 way to reach it
            return 1;
        }
        if (i < 0 || j < 0) {  //out of bounds
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = recursion(i - 1, j, dp);
        int left = recursion(i, j - 1, dp);
        return dp[i][j] = left + up;
    }

    private int tab(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //at base case (0,0) only 1 way to reach
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }

        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        lc62 sol = new lc62();
        System.out.println("Unique Paths (3x2): " + sol.uniquePaths(3, 2)); // Output: 3
        System.out.println("Unique Paths (3x7): " + sol.uniquePaths(3, 7)); // Output: 28
    }
}
