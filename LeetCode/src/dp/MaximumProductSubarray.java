package dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int tempMax = max;
            max = Math.max(cur, Math.max(cur * tempMax, cur * min));
            min = Math.min(cur, Math.min(cur * tempMax, cur * min));
            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();

        int[] nums1 = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums1));  // Output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println(solution.maxProduct(nums2));  // Output: 0

        int[] nums3 = {-2, 3, -4};
        System.out.println(solution.maxProduct(nums3));  // Output: 24

        int[] nums4 = {2, 3, -2, 4, -1};
        System.out.println(solution.maxProduct(nums4));  // Output: 48
    }
}
