package slidingwindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int result = 0, count = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            right++;

            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        System.out.println(solution.longestOnes(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}, 2)); // Output: 7
        System.out.println(solution.longestOnes(new int[]{1, 0, 1, 0, 0, 0, 1, 1}, 2)); // Output: 4
    }
}
