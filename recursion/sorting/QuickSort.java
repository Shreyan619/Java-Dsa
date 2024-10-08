
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int hi = end;
        int mid = low + (hi - low) / 2;
        int pivot = arr[mid];

        while (low <= hi) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[hi] > pivot) {
                hi--;
            }
            if (low <= hi) {
                int temp = arr[low];
                arr[low] = arr[hi];
                arr[hi] = temp;
                low++;
                hi--;
            }
        }
        sort(arr, start, hi);
        sort(arr, low, end);
    }
}
