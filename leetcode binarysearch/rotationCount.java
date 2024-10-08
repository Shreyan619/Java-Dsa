public class rotationCount {
    public static void main(String[] args) {
        int[] num = { 4, 5, 6, 0, 1, 2 };
        System.out.println(findKRotation(num));
    }

    public static int findKRotation(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[end]) {
                if (nums[start] < ans) {
                    ans = nums[start];
                    index = start;
                    break;
                }
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] < ans) {
                    ans = nums[start];
                    index = start;
                }
                start = mid + 1;
            } else {

                if (nums[mid] < ans) {
                    ans = nums[mid];
                    index = mid;

                }
                end = mid - 1;
            }
        }
        return index;
    }
}
