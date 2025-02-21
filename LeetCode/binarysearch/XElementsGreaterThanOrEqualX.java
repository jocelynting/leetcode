package binarysearch;

import java.util.Arrays;

public class XElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length;

        while (left <= right) {
            int mid =  left + (right - left) / 2;

            int count = caculate(nums, mid);

            if (count == mid) {
                return count;
            } else if (count > mid){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

    private int caculate(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        XElementsGreaterThanOrEqualX solution = new XElementsGreaterThanOrEqualX();
        int[] nums1 = {3,5};
        int[] nums2 = {0,0};
        int[] nums3 = {0,4,3,0,4};
        System.out.println(solution.specialArray(nums1));// Output: 2
        System.out.println(solution.specialArray(nums2));// Output: -1
        System.out.println(solution.specialArray(nums3));// Output: 3
    }
}
