// this is partially sorted matrix

// last value of row[0] can be greater than 1st value of row[1]
// last value of row[1] can be greater than 1st value of row[2]

public class lc240 {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        System.out.println(matrix(arr, 65));
    }

    static boolean matrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col>=0) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
