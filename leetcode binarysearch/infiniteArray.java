public class infiniteArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 7, 9, 11, 23, 24, 34, 35, 56, 67, 68, 69 };
        int target = 11;
        System.out.println(findingRange(arr, target));
    }

    static int findingRange(int[] arr, int target) {
        int start = 0;
        int end = 1;
        // first find the range
        // first start with a box of size 2
        while (target > arr[end]) {
            int newStart = end + 1;
            // end=previous end + sizeofbox*2
            int newSize = (end - start + 1) * 2;
            end = start + newSize;
            start = newStart;
        }
        return infinArray(arr, target, start, end);
    }

    static int infinArray(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
