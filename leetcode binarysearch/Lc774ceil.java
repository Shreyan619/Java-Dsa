public class Lc774ceil {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'm';
        char op = nextGreatestLetter(letters, target);
        System.out.println(op);
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
        // if (start == end) {
        // return letters[0];
        // } else {
        // return letters[start];
        // }
    }
}
