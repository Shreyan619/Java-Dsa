
public class lc202 {

    public boolean isHappy(int n) {
        double s = 0;
        while (n >= 0) {
            int d = n % 10;
            double p = Math.pow(d, 2);
            s = s + p;
            n = n / 10;
            if (s == 1) {
                return true;
            }
        }
        return false;
    }

    private int sum(int n) {
        int s = 0;
        while (n >= 0) {
            int d = n % 10;
            s += d * d;
            n = n / 10;
        }
        return s;
    }
}
