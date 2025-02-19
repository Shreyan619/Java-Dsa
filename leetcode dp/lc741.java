
import java.util.Arrays;

// cherry pickup with obstacle and return to 0,0
public class lc741 {

    int dp[][][];
    int grid[][];
    int n;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        int dp[][][] = new int[n][n][n];
        for (int[][] r : dp) {
            for (int[] row : r) {
                Arrays.fill(row, -1);
            }
        }
        // If the result is negative (no valid path), we return 0
        return Math.max(0, helper(0, 0, 0));
    }

    private int helper(int row1, int col1, int col2) {
        int row2 = row1 + col1 - col2;
        // int n = grid.length;

        if (row1 >= n || row2 >= n || col1 >= n || col2 >= n
                || grid[row1][col1] == -1 || grid[row2][col2] == -1) {

            return Integer.MIN_VALUE;
        } else if (row1 == n - 1 && col1 == n - 1) {
            return grid[row1][col1];
        } else if (dp[row1][col1][col2] != -1) {

            return dp[row1][col1][col2];
        } else {
            int ans = grid[row1][col1];
            if (col1 != col2) {
                ans += grid[row2][col2];
            }
            ans += Math.max(Math.max(helper(row1, col1 + 1, col2 + 1), helper(row1 + 1, col1, col2 + 1)),
                    Math.max(helper(row1, col1 + 1, col2), helper(row1 + 1, col1, col2)));
            dp[row1][col1][col2] = ans;
            return ans;
        }
    }
}
