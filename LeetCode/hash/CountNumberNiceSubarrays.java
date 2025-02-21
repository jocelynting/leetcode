package hash;

import java.util.HashMap;
import java.util.Map;

public class CountNumberNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }

            if (map.containsKey(count - k)) {
                result += map.get(count - k);
            }

            map.put(count, map.getOrDefault(count, 0) + 1);
        }

        return result;

    }

    public static void main(String[] args) {
        CountNumberNiceSubarrays solution = new CountNumberNiceSubarrays();
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(solution.numberOfSubarrays(nums1, k1));  // Output：2

        int[] nums2 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k2 = 2;
        System.out.println(solution.numberOfSubarrays(nums2, k2));  // Output：16
    }

}
