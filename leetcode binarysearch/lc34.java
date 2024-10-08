public class lc34 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 8, 10, 14 };
        int target = 8;
        System.out.println(searchRange(arr, target));
    }
    // Find First and Last Position of Element in Sorted Array

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        nums[0] = search(nums, target, true);
        if (nums[0] != -1) {
            nums[1] = search(nums, target, false);
        }
        return ans;
    }

    static int search(int[] nums, int target, boolean find1stIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (find1stIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
