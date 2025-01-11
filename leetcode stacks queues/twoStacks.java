//game of 2 stacks hackerrank

import java.util.List;

public class twoStacks {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return twoStacks(maxSum, a, b, 0, 0);
    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        if (sum > maxSum) {
            return count - 1;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return count;
        }
        int fromA = 0;
        if (!a.isEmpty()) {
            fromA = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);
        }
        int fromB = 0;
        if (!b.isEmpty()) {
            fromB = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);
        }
        return Math.max(fromA, fromB);
    }
}
