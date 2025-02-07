
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsGraph {

    public ArrayList<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v + 1];
        vis[0] = true;

        q.add(0);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (int i : adj.get(node)) {
                if (vis[i] == false) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
