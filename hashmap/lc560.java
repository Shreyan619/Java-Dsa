//560. Subarray Sum Equals K

import java.util.HashMap;

public class lc560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //<sum,frequency>
        map.put(0, 1);  //empty subarray has sum 0 and frequency 1

        int count = 0;
        int sum = 0;
        for (int j : nums) {
            count += j;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // map.getOrDefault(sum, 0) + 1 ensures:
            // If sum already exists, increase its count.
            // If sum is new, set count to 1.
        }
        return count;
    }
}
// nums = {10, 2, -2, -20, 10} and k = -10
