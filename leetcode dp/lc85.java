
import java.util.Stack;

// maximal rectangle
public class lc85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int area = 0;
        int n = matrix.length, m = matrix[0].length;
        int histogram[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }
            area = Math.max(area, getMax(histogram));
        }
        return area;
    }

    private int getMax(int[] max) {
        int maxArea = 0;
        int n = max.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currheight = (i == n) ? 0 : max[i];
            while (!stack.isEmpty() && currheight < max[stack.peek()]) {
                int height = max[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
