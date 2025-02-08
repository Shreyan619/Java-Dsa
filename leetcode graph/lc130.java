// 130. Surrounded Regions

public class lc130 {

    public void solve(char[][] board) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
//traverse 1st and last rows
        for (int j = 0; j < m; j++) {
            // check for unvisited Os in the boundary rws
            //first row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delRow, delCol);
            }
            //last row
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            // 1st col
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delRow, delCol);
            }
            //last col
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delRow, delCol);
            }
        }
        //inner board if univisited 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, int[][] vis, char[][] board, int[] delRow, int[] delCol) {
        vis[r][c] = 1;
        int n = board.length;
        int m = board[0].length;
        // check for top, right, bottom, left 
        for (int i = 0; i < 4; i++) {
            int newRow = r + delRow[i];
            int newCol = c + delCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0
                    && board[newRow][newCol] == 'O') {
                dfs(newRow, newCol, vis, board, delRow, delCol);
            }
        }
    }
}
