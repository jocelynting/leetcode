package twopoint;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        int left = 0, right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                result++;
                left++;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs solution = new MaxNumberOfKSumPairs();
        System.out.println(solution.maxOperations(new int[]{1, 2, 3, 4}, 5)); // Output: 2
        System.out.println(solution.maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // Output: 1
    }
}
