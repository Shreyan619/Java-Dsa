
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

    //optimal approach efficient
    public int largestRectangle(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) { // left part calculation
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear(); // clear stack for right calc
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }
}
