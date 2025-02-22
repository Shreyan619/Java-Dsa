// Max Consecutive Ones III

public class lc1004 {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, len = 0, zeroCount = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return  len;
    }
}
