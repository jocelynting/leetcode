package greedy;

import java.util.Arrays;

public class MinimumIncrementMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
                result += increment;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumIncrementMakeArrayUnique solution = new MinimumIncrementMakeArrayUnique();
        int[] nums = {3, 2, 1, 2, 1, 7};
        System.out.println(solution.minIncrementForUnique(nums)); // Output: 6
    }
}
