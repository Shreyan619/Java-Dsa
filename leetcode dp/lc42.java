//trap rainwater

public class lc42 {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxleft = 0, maxright = 0, totalwater = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    totalwater += maxleft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxright) {
                    maxright = height[right];
                } else {
                    totalwater += maxright - height[right];
                }
                right--;
            }
        }
        return totalwater;
    }
}
