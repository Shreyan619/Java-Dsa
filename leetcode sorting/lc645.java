// set mismatch
import java.util.Arrays;

public class lc645 {
    public static void main(String[] args) {
        int[] arr = { 1,1 };
        int[] result = findErrorNums(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {

                return new int[] { nums[j], j + 1 };
            }
        }
        return new int[] { -1, -1 };
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
