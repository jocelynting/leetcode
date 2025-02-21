package array;

import java.util.Arrays;

public class MinimumAverage {
    public double minimumAverage(int[] nums) {

        Arrays.sort(nums);
        double min = Double.MAX_VALUE;

        for (int i = 0; i < nums.length / 2; i++) {
            double temp = (nums[i] + nums[nums.length - i - 1]) / 2.0;
            min = Math.min(min, temp);
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumAverage solution = new MinimumAverage();
        int[] nums1 = {7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println(solution.minimumAverage(nums1));// Output: 5.5
        int[] nums2 = {1, 2, 3, 7, 8, 9};
        System.out.println(solution.minimumAverage(nums2));// Output: 5.0
    }
}
