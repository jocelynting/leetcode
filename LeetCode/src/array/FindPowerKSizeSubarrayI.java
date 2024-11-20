package array;

import java.util.Arrays;

public class FindPowerKSizeSubarrayI {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Arrays.fill(result, -1);
        int count = 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                result[i - k + 2] = nums[i + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindPowerKSizeSubarrayI solution = new FindPowerKSizeSubarrayI();
        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.resultsArray(nums1, k1)));// Output: [3, 4, -1, -1, -1]

        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        System.out.println(Arrays.toString(solution.resultsArray(nums2, k2)));// Output: [-1, -1]
    }
}
