
import java.util.Arrays;

// v vv v v imp 3d dp matrix
// 1463. Cherry Pickup II
public class lc1463 {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return memoSol(0, 0, m - 1, n, m, grid, dp);
    }

    private int memoSol(int i, int j1, int j2, int row, int col, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= col || j2 >= col) {
            return Integer.MIN_VALUE;
        }

        // If we are at the last row, return the sum of chocolates in the selected columns
        if (i == row - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int max = Integer.MIN_VALUE;
        // all 9 paths 1
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                // If j1 and j2 are the same, add chocolates from j1 || j2 only
                if (j1 == j2) {
                    ans = grid[i][j1] + memoSol(i + 1, j1 + di, j2 + dj, row, col, grid, dp);
                } else {
                    ans = grid[i][j1] + grid[i][j2] + memoSol(i + 1, j1 + di, j2 + dj, row, col, grid, dp);
                }
                max = Math.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;

    }

    private int space(int[][] grid) {  //not correct
        int n = grid.length;
        int m = grid[0].length;
        // Create two 2D arrays to store computed results: prev and cur
        int[][] prev = new int[m][m];
        int curr[][] = new int[m][m];

        // Initialize the prev array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    prev[j1][j2] = grid[n - 1][j1];
                } else {
                    prev[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }
        // traverse from 2nd last row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;

                    // now check all 9 paths
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            int newj1 = j1 + di;
                            int newj2 = j2 + dj;
                            if (newj1 >= 0 && newj1 < m && newj2 >= 0 && newj2 < m) {
                                if (j1 == j2) {
                                    ans = grid[i][j1];
                                } else {
                                    ans = grid[i][j1] + grid[i][j2];
                                }
                                ans += prev[newj1][newj2];
                                max = Math.max(ans, max);
                            }
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            prev = curr;
        }
        int ans = Integer.MIN_VALUE;
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                ans = Math.max(ans, prev[j1][j2]);
            }
        }
        return ans;
    }
}
