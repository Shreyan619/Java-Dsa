
import java.util.Arrays;

public class bubblesort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 32, 1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr) {
        boolean swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {   //!false=true
                break;
            }
        }
    }
}
