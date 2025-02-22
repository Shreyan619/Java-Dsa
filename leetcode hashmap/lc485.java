// Max Consecutive Ones
public class lc485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, len = 0, zeroCount = 0;
        int n = nums.length;

        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            //if more than 0 zero decrease count and move left forwrd
            while (zeroCount > 0) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            // update max len of 1's
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println(findMaxConsecutiveOnes(nums1)); // Output: 3
        // System.out.println(findMaxConsecutiveOnes(nums2)); // Output: 2
    }
}
