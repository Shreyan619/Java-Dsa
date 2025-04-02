
import java.util.*;

public class prime {

    static boolean isprime(int n) {
        int c = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c == 0) {
            return true;
        }
        return false;
    }

    static int getnthPrime(int n) {
        int count = 0, num = 1;
        while (count < n) {
            num++;
            if (isprime(num)) {
                count++;
            }
        }
        return num;
    }

    static int Pr(int x, int y) {
        int a = getnthPrime(x);
        int b = getnthPrime(y);
        int c = a * b - 1;
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Pr(5,3));
    }

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     // System.err.print("enter rows");
    //     // int n = scanner.nextInt();
    //     int[][] arr = new int[3][2];
    //     for (int row = 0; row < arr.length; row++) {
    //         // System.out.print("Enter the number of elements for row " + (row + 1) + ": ");
    //         // int numElements = scanner.nextInt();
    //         // arr[row] = new int[numElements];
    //         for (int col = 0; col < arr[row].length; col++) {
    //             arr[row][col] = scanner.nextInt();
    //         }
    //     }
    //     for (int row = 0; row < arr.length; row++) {
    //         System.out.println(Arrays.toString(arr[row]));
    //         // for (int col = 0; col < arr[row].length; col++) {
    //         // System.out.println(arr[row][col] + " ");
    //         // }
    //         // System.out.println();
    //     }
    //     scanner.close();
    // }
}
