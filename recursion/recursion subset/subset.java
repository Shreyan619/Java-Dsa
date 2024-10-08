
import java.util.*;

public class subset {

    public static void main(String[] args) {
        String str = "abcd";
        List<String> subs = new ArrayList<>(100);
        Sub(str, "", subs);
        System.out.println(subs);
    }

    static void Sub(String s, String add, List<String> Subs) {
        if (s.isEmpty()) {
            Subs.add(add);
            return;
        }
        char c = s.charAt(0);
        Sub(s.substring(1), add + c, Subs);
        Sub(s.substring(1), add, Subs);
    }
}
