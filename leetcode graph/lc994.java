// 994. Rotting Oranges
//v v v v v v impppppp

import java.util.LinkedList;
import java.util.Queue;

public class lc994 {
//only add rotten oranges to the queue when grid==2

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int time = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll(); // Get the rotten orange's position
                int row = cell[0];
                int col = cell[1];

                for (int j = 0; j < 4; j++) {
                    int newRow = row + drow[j];
                    int newCol = col + dcol[j];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.add(new int[]{newRow, newCol});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                time++;
            }
        }
        return fresh == 0 ? time : -1;
    }

}
