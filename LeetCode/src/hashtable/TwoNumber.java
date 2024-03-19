package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumber {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                result[0] = i;
                result[1] = map.get(rest);
                break;
            } else {
                map.put(nums[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoNumber solution = new TwoNumber();

        // Test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Expected output: [0, 1]
    }

}
