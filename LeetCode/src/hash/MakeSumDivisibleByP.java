package hash;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int n : nums) {
            total = (total + n) % p;
        }

        if (total % p == 0) {
            return 0;
        }

        int remainder = total % p;
        int length = nums.length;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (prefix - remainder + p) % p;

            if (map.containsKey(target)) {
                length = Math.min(length, i - map.get(target));
            }

            map.put(prefix, i);
        }

        return length == nums.length ? -1 : length;

    }

    public static void main(String[] args) {
        MakeSumDivisibleByP solution = new MakeSumDivisibleByP();
        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println(solution.minSubarray(nums1, p1)); // Output: 1

        int[] nums2 = {6, 3, 5, 2};
        int p2 = 9;
        System.out.println(solution.minSubarray(nums2, p2)); // Output: 2

        int[] nums3 = {1, 2, 3};
        int p3 = 3;
        System.out.println(solution.minSubarray(nums3, p3)); // Output: 0

        int[] nums4 = {1, 2, 3};
        int p4 = 7;
        System.out.println(solution.minSubarray(nums4, p4)); // Output: -1
    }
}
