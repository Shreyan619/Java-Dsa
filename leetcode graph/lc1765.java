
import java.util.LinkedList;
import java.util.Queue;

// 1765. Map of Highest Peak
public class lc1765 {

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] height = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;  //-1 is just a marker for unprocessed cells and actually used in calculations
                }
            }
        }
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = height[row][col] + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return height;
    }
}
