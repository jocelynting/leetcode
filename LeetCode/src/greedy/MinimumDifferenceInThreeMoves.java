package greedy;

import java.util.Arrays;

public class MinimumDifferenceInThreeMoves {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= 3; i++) {
            min = Math.min(min, nums[nums.length - 4 + i] - nums[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumDifferenceInThreeMoves solution = new MinimumDifferenceInThreeMoves();
        System.out.println(solution.minDifference(new int[]{5, 3, 2, 4})); // Output: 0
        System.out.println(solution.minDifference(new int[]{1, 5, 0, 10, 14})); // Output: 1
        System.out.println(solution.minDifference(new int[]{6, 6, 0, 1, 1, 4, 6})); // Output: 2
        System.out.println(solution.minDifference(new int[]{1, 5, 6, 14, 15})); // Output: 1
    }
}
