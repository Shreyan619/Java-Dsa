
public class Q1 {

    public static void main(String[] args) {
        String tar = "abcdebh";
        char c = 'b';
        System.out.println(skip(tar, c));
        String str = "abcxyzabcxyz";
        String toRemove = "abc";
        String result = skipword(str, toRemove);
        System.out.println(result);
    }

    static String skip(String up, char tar) {
        if (up.isEmpty()) {
            System.out.println(up);
            return "";
        }
        char c = up.charAt(0);

        if (tar == c) {
            return skip(up.substring(1), tar);
        } else {
            return c + skip(up.substring(1), tar);
        }
    }

    static String skipword(String s, String remove) {
        if (s.length() < remove.length()) {
            return s;
        }

        if (s.startsWith(remove)) {
            return skipword(s.substring(remove.length()), remove);
        } else {
            return s.charAt(0) + skipword(s.substring(1), remove);
        }
    }
}
