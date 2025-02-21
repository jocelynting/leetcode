package binarysearch;

import java.util.Arrays;

public class CountNumberOfFairPairs {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        int n = nums.length;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            long l = binarySearch(nums, i + 1, n, lower - nums[i]);
            long u = binarySearch(nums, i + 1, n, upper - nums[i] + 1);

            result += (u - l);
        }

        return result;
    }

    private long binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        CountNumberOfFairPairs solution = new CountNumberOfFairPairs();

        int[] nums1 = {0, 1, 7, 4, 4, 5};
        System.out.println(solution.countFairPairs(nums1, 3, 6)); // Output: 6

        int[] nums2 = {1, 7, 9, 2, 5};
        System.out.println(solution.countFairPairs(nums2, 11, 11)); // Output: 1
    }
}
