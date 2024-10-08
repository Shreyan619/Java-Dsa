// this is for strictly sorted matrix
// like last value of row 0<1st value of row1 same row[1]valuelast < row[2]value1st
public class lc74 {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 30, 40 },
                { 50, 60, 70, 80 },
                { 90, 100, 110, 120 }
        };
        int target = 10;
        System.out.println(search(arr, target));
    }

    static boolean search(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int start = 0;
        int end = n * m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / m;
            int col = mid % m;
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
