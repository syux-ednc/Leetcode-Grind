package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(target - nums[i])) {
                ans[0] = tempMap.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            tempMap.put(nums[i], i);
        }
        return ans;
    }
}
