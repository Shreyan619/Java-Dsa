// 200. Number of Islands

public class lc200 {

    public int numIslands(char[][] grid) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;

        // check inner board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, vis, grid, delRow, delCol);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, boolean[][] vis, char[][] grid, int[] delRow, int[] delCol) {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = r + delRow[i];
            int nCol = c + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == false
                    && grid[nRow][nCol] == '1') {
                dfs(nRow, nCol, vis, grid, delRow, delCol);
            }

        }
    }
}
