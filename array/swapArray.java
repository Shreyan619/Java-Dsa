
import java.util.Arrays;
import java.util.Scanner;

public class swapArray {
    public static void main(String[] args) {
        Scanner nb = new Scanner(System.in);
        System.out.print("enter array size : ");
        int size = nb.nextInt();
        int[] arr = new int[size];
        inputElements(arr);
        swap(arr, 2, 0);
        System.out.println(Arrays.toString(arr));
        nb.close();
    }

    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void inputElements(int arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    }
}
