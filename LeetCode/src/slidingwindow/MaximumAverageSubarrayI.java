package slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double average = Double.NEGATIVE_INFINITY, sum = 0;
        int n = nums.length;
        int left = 0, right = 0;

        while (right < n) {
            sum += nums[right];
            right++;

            if (right - left == k) {
                average = Math.max(average, sum / k);
                sum -= nums[left];
                left++;
            }
        }


        return average;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI solution = new MaximumAverageSubarrayI();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // Output: 12.75
        System.out.println(solution.findMaxAverage(new int[]{5}, 1)); // Output: 5
    }
}
