//no of provinces

public class lc547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, boolean[] vis, int[][] isconnect) {
        vis[node] = true;

        for (int i = 0; i < isconnect.length; i++) {
            if (isconnect[node][i] == 1 && !vis[i]) {
                dfs(i, vis, isconnect);
            }
        }
    }
}
