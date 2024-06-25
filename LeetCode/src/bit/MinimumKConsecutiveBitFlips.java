package bit;

public class MinimumKConsecutiveBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int result = 0;
        int flipCount = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= flip[i - k];
            }
            if ((nums[i] ^ flipCount) == 0) {
                if (i + k > n) {
                    return -1;
                }
                result++;
                flipCount ^= 1;
                flip[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumKConsecutiveBitFlips solution = new MinimumKConsecutiveBitFlips();
        int[] nums1 = {0, 1, 0};
        int k1 = 1;
        System.out.println(solution.minKBitFlips(nums1, k1)); // Output: 2

        int[] nums2 = {1, 1, 0};
        int k2 = 2;
        System.out.println(solution.minKBitFlips(nums2, k2)); // Output: -1

        int[] nums3 = {0, 0, 0, 1, 0, 1, 1, 0};
        int k3 = 3;
        System.out.println(solution.minKBitFlips(nums3, k3)); // Output: 3
    }
}
