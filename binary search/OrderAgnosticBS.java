public class OrderAgnosticBS {
    public static void main(String[] args) {
        // int[] arr = { 15, 48, 78, 654, 977 };
        int[] arr = { 977, 654, 78, 48, 15 };
        int target = 977;
        System.out.println(Bs(arr, target));
    }

    static int Bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
