// import java.util.Arrays;

public class lc81 {

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 3, 3, 3, 3 };
        int target = 3;
        System.out.println(search(arr, target));
    }

    static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
