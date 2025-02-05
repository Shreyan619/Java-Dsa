
import java.util.HashMap;
import java.util.HashSet;

public class majority {

    public static class IntersectionResult {

        int count;
        HashSet<Integer> remainingSet;

        public IntersectionResult(int count, HashSet<Integer> remainingSet) {
            this.count = count;
            this.remainingSet = remainingSet;
        }
    }

    public static void majorityEle(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }

    public void union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println(set);
    }

    public IntersectionResult intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                count++;
                intersectionSet.add(arr2[i]);
            }
        }
        return new IntersectionResult(count, intersectionSet);
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 5, 3, 3, 3, 5, 1};
        // majorityEle(nums);
        majority solution = new majority();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        IntersectionResult result = solution.intersection(arr1, arr2);
        System.out.println("Count of intersecting elements: " + result.count);
        System.out.println("New set after intersection: " + result.remainingSet);
    }
}
