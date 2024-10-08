public class evenDigitsArray {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(Nos(nums));
    }

    static int Nos(int[] arr) {
        int c = 0;
        for (int i : arr) {
            if (evenDigits(i)) {
                c++;
            }
        }
        return c;
    }

    static boolean evenDigits(int n) {
        int noOfDigits = digits(n);
        return noOfDigits % 2 == 0;
    }

    static int digits(int n) {
        if (n < 0) {
            n *= -1;
        }
        int count = 0;
        if (n == 0) {
            count = 1;
        }
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Shortcut to find nos of digits in a no
    static int dig(int n) {
        return (int) (Math.log10(n)) + 1;
    }

}
