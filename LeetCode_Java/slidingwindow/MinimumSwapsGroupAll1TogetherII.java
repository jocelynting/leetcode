package slidingwindow;

public class MinimumSwapsGroupAll1TogetherII {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum == 0 || sum == n) {
            return 0;
        }

        int[] extend = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extend[i] = nums[i];
            extend[i + n] = nums[i];
        }

        int window = sum;
        int cur = 0, max = 0;

        for (int i = 0; i < window; i++) {
            cur += extend[i];
        }
        max = cur;

        for (int i = window; i < 2 * n; i++) {
            cur = cur - extend[i - window] + extend[i];
            max = Math.max(max, cur);
        }

        return window - max;
    }

    public static void main(String[] args) {
        MinimumSwapsGroupAll1TogetherII solution = new MinimumSwapsGroupAll1TogetherII();
        int[] nums1 = {0, 1, 0, 1, 1, 0, 1, 0};
        System.out.println(solution.minSwaps(nums1)); // Output: 1

        int[] nums2 = {1, 0, 1, 0, 1, 0, 1, 0};
        System.out.println(solution.minSwaps(nums2)); // Output: 2

        int[] nums3 = {1, 0, 0, 1, 1, 0, 1, 0};
        System.out.println(solution.minSwaps(nums3)); // Output: 1
    }
}
