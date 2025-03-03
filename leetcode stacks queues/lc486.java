
import java.util.HashMap;
import java.util.Stack;

// 496. Next Greater Element I
public class lc486 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        // if no greater ele then return -1 value
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int res[] = new int[nums1.length + 1];
        // Build result for nums1 using the precomputed map
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
