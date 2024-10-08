import java.util.Arrays;

public class lc1901 {

    public static void main(String[] args) {
        int arr[][] = {
                // { 4, 2, 5, 1, 4, 5 },
                // { 2, 9, 3, 2, 3, 2 },
                // { 1, 7, 6, 0, 1, 3 },
                // { 3, 6, 2, 3, 7, 2 }
                {1,4},{3,2}
        };
        System.out.println(Arrays.toString(findpeak(arr)));
    }

    static int[] findpeak(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int start = 0;
        int end = m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = maxEle(mat, mid, n);
            int left = mid > 0 ? mat[row][mid - 1] : -1;
            int right = mid < m - 1 ? mat[row][mid + 1] : -1;
            if (left < mat[row][mid] && right < mat[row][mid]) {
                return new int[] { row, mid };
            } else if (mat[row][mid] < left) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return new int[] { -1, -1 };
    }

    static int maxEle(int mat[][], int col, int n) {
        int maxVal = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}


