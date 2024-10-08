//range of xors between a and b
//very impppppppppppp

public class XorRange {

    public static void main(String[] args) {
        int a = 3;
        int b = 7;
        System.out.println(xor_range(a, b));
    }

    static int xor_range(int a, int b) {
        return range(a - 1) ^ range(b);
    }

    static int range(int n) {
        if (n % 4 == 0) {
            return n;
        }
        if (n % 4 == 1) {
            return 1;
        }
        if (n % 4 == 2) {
            return n + 1;
        }
        return 0;
    }
}
