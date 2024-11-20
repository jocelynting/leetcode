package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > sub.get(sub.size() - 1)) {
                sub.add(cur);
            } else {
                int index = binarySearch(sub, cur);
                sub.set(index, cur);
            }
        }

        return sub.size();
    }

    private int binarySearch(List<Integer> sub, int target) {
        int left = 0, right = sub.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sub.get(mid) < target) {
                left = mid + 1;
            } else if (sub.get(mid) > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums1)); // Output: 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums2)); // Output: 4
    }
}
