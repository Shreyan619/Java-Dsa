// min falling path sum

public class lc931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[n]; //array to store prev row values

        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) { //as row 1 has been initialized
            int curr[] = new int[n];//store current row
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];
                int left = (j > 0) ? matrix[i][j] + prev[j - 1] : Integer.MAX_VALUE;
                int right = (j < m - 1) ? matrix[i][j] + prev[j + 1] : Integer.MAX_VALUE; // No right diagonal for the last column
                curr[j] = Math.min(up, Math.min(left, right));
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE; // as we have to find the minimum value
        for (int val : prev) {
            ans = Math.min(val, ans); // Find the minimum in the last row
        }
        return ans;
    }
}
