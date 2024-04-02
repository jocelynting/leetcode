package binarysearch;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;

        for (int num: nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countPartitions(nums, mid) <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countPartitions(int[] nums, int sum) {
        int total = 0;
        int partition = 0;

        for (int num: nums) {
            total += num;
            if (total > sum) {
                partition++;
                total = num;
            }
        }

        if (total > 0) {
            partition++;
        }

        return partition;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(solution.splitArray(nums, k)); // Output: 9
    }
}
