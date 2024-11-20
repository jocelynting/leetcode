package twopoint;

import java.util.Arrays;

public class CountNumberOfFairPairs {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return calculate(nums, upper + 1) - calculate(nums, lower);
    }

    private long calculate(int[] nums, int value) {
        long result = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountNumberOfFairPairs solution = new CountNumberOfFairPairs();

        int[] nums1 = {0, 1, 7, 4, 4, 5};
        System.out.println(solution.countFairPairs(nums1, 3, 6)); // Output: 6

        int[] nums2 = {1, 7, 9, 2, 5};
        System.out.println(solution.countFairPairs(nums2, 11, 11)); // Output: 1
    }
}
