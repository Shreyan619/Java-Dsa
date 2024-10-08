
import java.util.*;

public class prime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.err.print("enter rows");
        // int n = scanner.nextInt();

        int[][] arr = new int[3][2];
        for (int row = 0; row < arr.length; row++) {
            // System.out.print("Enter the number of elements for row " + (row + 1) + ": ");
            // int numElements = scanner.nextInt();
            // arr[row] = new int[numElements];
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = scanner.nextInt();
            }
        }
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
            // for (int col = 0; col < arr[row].length; col++) {
            // System.out.println(arr[row][col] + " ");
            // }
            // System.out.println();
        }

        scanner.close();
    }
}
