package hash;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixMod = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (map.containsKey(prefixMod)) {
                if (i - map.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                map.put(prefixMod, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("Test Case 1: " + solution.checkSubarraySum(nums1, k1));// Output: true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println("Test Case 2: " + solution.checkSubarraySum(nums2, k2));// Output: true

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println("Test Case 3: " + solution.checkSubarraySum(nums3, k3));// Output: false
    }
}
