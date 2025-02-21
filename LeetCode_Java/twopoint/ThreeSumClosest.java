package twopoint;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
            }

        }

        return target - diff;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(solution.threeSumClosest(nums1, target1)); // Expected output: 2

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println(solution.threeSumClosest(nums2, target2)); // Expected output: 0

        int[] nums3 = {1, 1, 1, 1};
        int target3 = 3;
        System.out.println(solution.threeSumClosest(nums3, target3)); // Expected output: 3

        int[] nums4 = {1, 1, -1, -1, 3};
        int target4 = -1;
        System.out.println(solution.threeSumClosest(nums4, target4)); // Expected output: -1
    }
}
