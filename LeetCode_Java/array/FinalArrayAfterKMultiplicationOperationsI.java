package array;

import java.util.Arrays;

public class FinalArrayAfterKMultiplicationOperationsI {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        while (k > 0) {
            int index = minIndex(nums);
            nums[index] = nums[index] * multiplier;
            k--;
        }

        return nums;
    }

    private int minIndex(int[] nums) {
        int min = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        FinalArrayAfterKMultiplicationOperationsI solution = new FinalArrayAfterKMultiplicationOperationsI();
        int[] nums1 = {2, 1, 3, 5, 6};
        System.out.println(Arrays.toString(solution.getFinalState(nums1, 5, 2)));
        // Output: [8,4,6,5,6]

        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(solution.getFinalState(nums2, 3, 4)));
        // Output: [16,8]
    }
}
