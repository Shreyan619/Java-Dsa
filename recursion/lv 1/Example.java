
public class Example {

    public static void main(String[] args) {
        // func(0, 4);
        // revfunc(5);
        // System.out.println(fact(5));
        // System.out.println(sumofdigits(5555));
        // nos(5);
        int[] arr = {1, 3, 5, 6, 9, 40};
        System.out.println(sorted(arr, 0));
    }

    static void func(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        func(i + 1, n);
    }

    static void revfunc(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        revfunc(n - 1);
    }

    //factorial
    static int fact(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
//sum of digits of no

    static int sumofdigits(int n) {
        if (n == 0) {
            return 0;
        }
        return ((n % 10) + sumofdigits(n / 10));
    }

    static void nos(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        nos(--n);
    }

    static boolean sorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && sorted(arr, index + 1);
    }
}
