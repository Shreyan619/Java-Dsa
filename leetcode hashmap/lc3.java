
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class lc3 {

    public int lengthOfLongestSubstring(String s) {  //O(n^2)
        if (s.length() == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) { // outer loop for traversing the string
            Set<Character> hashSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {  // inner loop for finding the longest substring
                if (hashSet.contains(s.charAt(j))) {
                    max = Math.max(max, j - i);
                    break;
                }
                hashSet.add(s.charAt(j));
            }
        }
        return max;
    }

    public int length(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int len = 0; //for storing substring length
        int left = 0, right = 0;
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
