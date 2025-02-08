//0/1 matrix

import java.util.LinkedList;
import java.util.Queue;

public class lc542 {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    dis[i][j] = -1; // Mark unprocessed 1s
// Since 0 cells are already in the queue (BFS starts from them), we need a way to differentiate between processed and unprocessed 1s.
// Using -1 ensures we only process these 1s later when they are reached in BFS.
                }
            }
        }
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            for (int i = 0; i < 4; i++) {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && dis[newRow][newCol] == -1) {
                    dis[newRow][newCol] = dis[row][col] + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return dis;
    }

}
