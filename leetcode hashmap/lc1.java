
import java.util.HashMap;

// 2sum

public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int tar=target-nums[i];
            if(map.containsKey(tar)){
                return new int[]{map.get(tar),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
