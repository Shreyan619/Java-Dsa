
import java.util.ArrayList;

public class permuatation {

    public static void main(String[] args) {
        String a = "abc";
        ArrayList<String> ans = pemArrayList("", a);
        System.out.println(permu("", a));

    }

    static int permu(String s, String tar) {
        if (tar.isEmpty()) {
            System.out.println(s);
            return 1;
        }
        int count = 0;
        char c = tar.charAt(0);
        for (int i = 0; i <= s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i, s.length());
            count = count + permu(first + c + second, tar.substring(1));

        }
        return count;
    }

    static ArrayList<String> pemArrayList(String s, String tar) {
        if (tar.isEmpty()) {
            ArrayList< String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> newList = new ArrayList<>();
        char c = tar.charAt(0);
        for (int i = 0; i <= s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i, s.length());
            newList.addAll(pemArrayList(first + c + second, tar.substring(1)));
        }
        return newList;
    }
}
// When tar.isEmpty() is true, it means that a valid permutation has been created, and we need to return a list containing that permutation (s).
// A new list (list) is created, and the current permutation (s) is added to it.
// This list is returned to the previous recursive call to be added to newList.
