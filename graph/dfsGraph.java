
import java.util.ArrayList;

public class dfsGraph {

    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        vis[node] = true;
        list.add(node);

        for (int i : adj.get(node)) {
            if (vis[i] == false) {
                dfs(i, vis, adj, list);
            }
        }
    }

    public ArrayList<Integer> dfsofgraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        vis[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(v, vis, adj, dfs);
        return dfs;
    }
}
