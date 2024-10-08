
public class subsequence {

    public static void main(String[] args) {
        String str = "abc";
        subseq(str);
    }

    static void subseq(String str) {
        int n = str.length();
        int totalsubsequence = 1 << n;  //2^n subsequences of string

        for (int i = 0; i < totalsubsequence; i++) {
            StringBuilder subsequences = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsequences.append(str.charAt(j));
                }
            }
            System.out.println(subsequences);
        }
    }
}
