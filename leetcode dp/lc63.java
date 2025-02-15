// unique path 2: obstacle in path

public class lc63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // if (obstacleGrid[0][0] == 1) {
        //     return 0;
        // }
        int prev[] = new int[m]; // array to store prev row values

        for (int i = 0; i < n; i++) {
            int temp[] = new int[m]; // store results for current row
            for (int j = 0; j < m; j++) {

                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0; // no path available due to obstacle

                } else if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = (i > 0) ? prev[j] : 0;
                    int left = (j > 0) ? temp[j - 1] : 0;
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }
}
