
public class lc17 {

    public static void main(String[] args) {
        Letter("", "56");
    }

    static void Letter(String s, String up) {
        if (up.isEmpty()) {
            System.out.println(s);
            return;
        }
        int d = up.charAt(0) - '0';//this will convert '2' into 2 like '0' has ascii value of 48
        //so if for eg 56 is put then at index 0 '5' which means '5' is equal to 53 -48=5
        for (int i = (d - 1) * 3; i < d * 3; i++) {
            char c = (char) ('a' + i);
            Letter(s + c, up.substring(1));
        }
    }
}
