import java.util.Arrays;

public class linearSearch {
    public static void main(String[] args) {
        String s = "Leornard";
        char tar = 'y';
        System.out.println(Arrays.toString(s.toCharArray()));
        System.out.println(Ls(s, tar));
    }

    static boolean Ls(String s, int target) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (target == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
