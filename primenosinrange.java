//Sieve of Eratosthenes method for finding prime numbers in a range.

public class primenosinrange {

    public static void main(String[] args) {
        int n = 11;
        boolean[] prime = new boolean[n + 1];//n+1 so that 40 is included as index starts from 0
        sieveoferatosthenes(n, prime);
    }

    static void sieveoferatosthenes(int n, boolean[] prime) {
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                //if false make all of its multiples true
                //j = 2 * i starts marking at the first multiple of i but leads to redundant work because
                // smaller primes have already marked those multiples.
                //j = i * i is an optimization that skips marking numbers already handled by smaller primes,
                // leading to fewer operations and making the sieve more efficient.
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
