package binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countPairs(int[] nums, int target) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance solution = new FindKthSmallestPairDistance();
        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println(solution.smallestDistancePair(nums1, k1)); // Output: 0

        int[] nums2 = {1, 6, 1};
        int k2 = 3;
        System.out.println(solution.smallestDistancePair(nums2, k2)); // Output: 5
    }
}
