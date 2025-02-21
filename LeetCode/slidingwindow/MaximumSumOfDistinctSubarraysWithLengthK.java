package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        return maximumSubarraySumByHashMap(nums, k);
        // return maximumSubarraySumByHashSet(nums, k);
    }

    private long maximumSubarraySumByHashMap(int[] nums, int k) {
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        long sum = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            while (map.get(nums[right]) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                result = Math.max(result, sum);
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return result;
    }

    private long maximumSubarraySumByHashSet(int[] nums, int k) {
        long result = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        long sum = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];
            right++;

            if (right - left == k) {
                result = Math.max(result, sum);
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSumOfDistinctSubarraysWithLengthK solution = new MaximumSumOfDistinctSubarraysWithLengthK();
        int[] nums1 = {1, 2, 1, 3, 4, 3};
        int k1 = 3;
        System.out.println(solution.maximumSubarraySum(nums1, k1)); // Output: 8

        int[] nums2 = {1, 2, 1, 2, 3};
        int k2 = 2;
        System.out.println(solution.maximumSubarraySum(nums2, k2)); // Output: 5
    }
}
