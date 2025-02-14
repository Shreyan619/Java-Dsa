//unique path
// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

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

    private int sc(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];
        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                } else {
                    int up = prev[j];
                    int left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
