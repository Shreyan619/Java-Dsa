// fruit into baskets

import java.util.HashMap;

public class lc904 {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0, len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                map.remove(fruits[left]);
                if (map.get(fruits[left]) == 0) {
                }
                left++;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
