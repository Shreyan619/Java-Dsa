public class lc1095 {
    public static void main(String[] args) {
        int[] mountainArray = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        System.out.println(findInMountainArray(target, mountainArray));
    }
// find in Mountain array
    static int findInMountainArray(int target, int[] mountainArr) {
        int peak = peakMountArr(mountainArr);
        int first = OrderAgnostic(mountainArr, target, 0, peak);
        if (first != -1) {
            return first;
        } else {
            // try to search in second half
            return OrderAgnostic(mountainArr, target, peak + 1, mountainArr.length - 1);
        }

    }

    static int peakMountArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int OrderAgnostic(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
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
