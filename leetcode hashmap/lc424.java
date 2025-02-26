
import java.util.HashMap;

// 424. Longest Repeating Character Replacement
public class lc424 {

    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while ((right - left + 1) - maxFreq > k) {
                char ch = s.charAt(left);
                map.put(ch, map.get(s.charAt(ch)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
