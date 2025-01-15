
import java.util.Stack;

// Largest Rectangle in Histogram
public class lc84 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> area = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!area.isEmpty() && heights[i] < heights[area.peek()]) {
                max = getMax(heights, area, max, i);
            }
            area.push(i);
        }
        int i = heights.length;
        while (!area.isEmpty()) {
            max = getMax(heights, area, max, i);
        }

        return max;
    }

    private int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = heights[popped] * i;
        } else {
            area = heights[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}
