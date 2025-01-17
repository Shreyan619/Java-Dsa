
import java.util.Stack;

public class lc1541 {

    public int minInsertions(String s) {
        int insert = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; //next is skipped because rule of keeping '))' together
                } else {
                    insert++;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    insert++;
                }
            }
        }
        return insert + 2 * stack.size();
    }

    public static void main(String[] args) {
        // Create an instance of the class containing minInsertions
        lc1541 solution = new lc1541();

        // Test cases
        // String test1 = "(()))"; // Expected output: 1
        // String test2 = "))()("; // Expected output: 6
        String test3 = "))()(";   // Expected output: 6

        // System.out.println("Test case 1: " + test1 + " -> " + solution.minInsertions(test1));
        // System.out.println("Test case 2: " + test2 + " -> " + solution.minInsertions(test2));
        System.out.println("Test case 3: " + test3 + " -> " + solution.minInsertions(test3));
    }

}
