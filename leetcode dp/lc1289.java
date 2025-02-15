// min falling path sum 2

public class lc1289 {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int prev[] = new int[n];
//intialize 1st row of grid
        for (int j = 0; j < n; j++) {
            prev[j] = grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) { //it's to find min in different columns
                    if (k != j) { //checks if current col is !=prev col(j)
                        min = Math.min(min, prev[k]);
                    }
                }
                curr[j] = grid[i][j] + min;
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for (int r : prev) {
            ans = Math.min(r, ans);
        }
        return ans;
    }
}
