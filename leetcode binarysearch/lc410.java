// Split array largest sum
public class lc410 {
    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(arr, k));
    }

    static int splitArray(int[] arr, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            start = Math.max(start, arr[i]); // to get max value of array
            end += arr[i];
        }
        // binary search
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num : arr) {
                if (sum + num > mid) {
                    // cannot add in this sub-array make a new one
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;// or return start as start==end
    }
}
