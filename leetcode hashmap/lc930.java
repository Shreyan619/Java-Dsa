// 930. Binary Subarrays With Sum

import java.util.HashMap;

public class lc930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int right = 0, sum = 0, c = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += nums[right];

            if (map.containsKey(sum - goal)) {
                c += map.get(sum - goal);
            }
            right++;
        }
        return c;
    }
}
