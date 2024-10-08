
import java.util.*;

public class selection {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int end) {
        if (end == 0) {
            return;
        }
        int maxindex = 0;
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxindex]) {
                maxindex = i;
            }
        }
        int temp = arr[maxindex];
        arr[maxindex] = arr[end];
        arr[end] = temp;
        selectionSort(arr, end - 1);
    }
}
