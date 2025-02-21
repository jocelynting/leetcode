package twopoint;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{++left, ++right};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices of the two numbers whose sum is equal to target: " + Arrays.toString(result));// Output: [1,2]
    }
}
