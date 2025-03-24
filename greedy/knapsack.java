
import java.util.*;

public class knapsack {

    static class Item {

        int val, weight;

        Item(int val, int wt) {
            this.val = val;
            this.weight = wt;
        }
    }

    static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) (a.val) / (double) (a.weight);
            double r2 = (double) (b.val) / (double) (b.weight);
            if (r1 > r2) {
                return -1;
            } else if (r1 < r2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public double Solve(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }

        Collections.sort(items, new ItemComparator());
        double total = 0.0;
        int remaining = capacity;
        for (Item item : items) {
            if (item.weight <= remaining) {
                total += item.val;
                remaining -= item.weight;
            } else {
                total += ((double) item.val / item.weight) * remaining;
                break;
            }
        }
        return total;
    }

}
