// find min in rotated sorted array
public class lc153 {
    public static void main(String[] args) {
        int[] arr = { 3,4,5,1,2 };
        System.out.println(findMin(arr));
    }

    static int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                ans = Math.min(ans, nums[start]);
                start = mid + 1;    //now check in right half
            } else {
                end = mid - 1;    //now check in left half
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}
// if(nums[start]<=nums[end]){
//     ans=Math.min(ans,nums[start]);
//     break;
// }