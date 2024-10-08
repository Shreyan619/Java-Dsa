public class binarySearch {
    public static void main(String[] args) {
        int[] arr = { 15, 48, 78, 654, 977 };
        int target = 67;
        System.out.println(Bs(arr, target));
    }

    static int Bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
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
        // return arr[start];// or {return start;} to get index
    }
}
// binary search works on sorted arrays