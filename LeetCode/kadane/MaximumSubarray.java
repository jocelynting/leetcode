package kadane;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curSum = Math.max(num, curSum + num);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected1 = 6;
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: " + expected1);
        System.out.println("Result: " + result1);

        // Test Case 2
        int[] nums2 = {1};
        int expected2 = 1;
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Test Case 2:");
        System.out.println("Expected: " + expected2);
        System.out.println("Result: " + result2);

        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int expected3 = 23;
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Test Case 3:");
        System.out.println("Expected: " + expected3);
        System.out.println("Result: " + result3);
    }
}
