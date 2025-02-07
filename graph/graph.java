
import java.util.ArrayList;


public class graph {

    public static void main(String[] args) {
        int n = 3, m = 3;
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
list.add(new ArrayList<Integer>());
        }
        // edge 1>2
        list.get(1).add(2);
        list.get(2).add(1);
// edge 2>3
        list.get(2).add(3);
        list.get(3).add(2);
// edge 1>3
        list.get(1).add(3);
        list.get(3).add(1);

        printGraph(list, n);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> list, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " → " + list.get(i));
            System.out.println();
        }
    }
}

