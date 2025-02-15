//min path sum

public class lc64 {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prev[] = new int[m];
        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = (i > 0) ? prev[j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? temp[j - 1] : Integer.MAX_VALUE;
                    temp[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }

    private int helper(int i, int j, int[][] dp, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        int up = grid[i][j] + helper(i - 1, j, dp, grid);
        int left = grid[i][j] + helper(i, j - 1, dp, grid);
        return dp[i][j] = Math.min(up, left);
    }
}
