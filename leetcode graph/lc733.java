// 733. Flood Fill

public class lc733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];  // get initial color
        int[][] ans = image;

// delta row and delta column for neighbours
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};
        dfs(image, sr, sc, ans, dRow, dCol, startColor, color);
        return ans;
    }

    private void dfs(int[][] image, int sr, int sc, int[][] ans, int[] nRow, int[] nCol, int startColor, int color) {
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = color;  // color with new color

        for (int i = 0; i < 4; i++) {   // there are exactly 4 neighbours
            int dRow = sr + nRow[i];
            int dCol = sc + nCol[i];
            // check for valid coordinate 
            // then check for same initial color and unvisited pixel
            if (dRow >= 0 && dRow < n && dCol >= 0 && dCol < m && image[dRow][dCol] == startColor
                    && ans[dRow][dCol] != color) {
                dfs(image, dRow, dCol, ans, nRow, nCol, startColor, color);
            }
        }
    }
}
