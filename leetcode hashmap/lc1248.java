
public class lc1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, ans = 0, odd = 0;

        while (right < n) {
            if (nums[right] % 2 == 1) {
                odd++;
            }
            while (odd > k) {
                if (nums[left] % 2 == 1) {
                    odd--;
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
// The Problem: atMostK(nums, k) Counts Too Many
// If we just used atMostK(nums, 3), it would include subarrays with:

// 0 odd numbers
// 1 odd number
// 2 odd numbers
// 3 odd numbers
// But we only want exactly 3 odd numbers!
// We need to remove the subarrays with 0, 1, and 2 odd numbers.
// How Do We Remove Unwanted Subarrays?
// We compute atMostK(nums, 2), which counts subarrays with at most 2 odd numbers.
// This includes:
// 0 odd numbers ✅
// 1 odd number ✅
// 2 odd numbers ✅
// 3 odd numbers ❌ (Not included)
