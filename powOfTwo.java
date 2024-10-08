//give a no tell if it is a power of 2 or not

public class powOfTwo {

    public static void main(String[] args) {
        int n = 16;
        boolean ans = (n & (n - 1)) == 0;
        System.out.println(ans);
    }
}
