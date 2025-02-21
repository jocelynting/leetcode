package twopoint;

import java.util.Arrays;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;

        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            if (l < r) {
                result[index] = r;
                index--;
                right--;
            } else {
                result[index] = l;
                index--;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SquaresSortedArray solution = new SquaresSortedArray();

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println("Test Case 1: " + Arrays.toString(solution.sortedSquares(nums1))); // Output: [0, 1, 9, 16, 100]

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println("Test Case 2: " + Arrays.toString(solution.sortedSquares(nums2))); // Output: [4, 9, 9, 49, 121]

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3: " + Arrays.toString(solution.sortedSquares(nums3))); // Output: [1, 4, 9, 16, 25]

        int[] nums4 = {-5, -4, -3, -2, -1};
        System.out.println("Test Case 4: " + Arrays.toString(solution.sortedSquares(nums4))); // Output: [1, 4, 9, 16, 25]

        int[] nums5 = {0};
        System.out.println("Test Case 5: " + Arrays.toString(solution.sortedSquares(nums5))); // Output: [0]
    }
}
