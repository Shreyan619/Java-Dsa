//setbits means no of 1s in the binary no

public class Countsetbits {

    public static void main(String[] args) {
        int n = 23;
        System.out.println(countbits(n));
    }

    static int countbits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
