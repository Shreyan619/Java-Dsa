
import java.util.Map;

public class lc287 {

    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            if (store.containsKey(i)) {
                return i;
            }
            store.put(i, 1);
        }
        return -1;
    }

    public int findDuplicates(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {  // Phase 1: Detect intersection point in cycle
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) { //phase 2 after duplicate detection
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // duplicate no
    }
}
