package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || n == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }

        if (nums[0] > lower) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if (nums[n - 1] < upper) {
            result.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return result;
    }

    public static void main(String[] args) {
        MissingRanges solution = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(solution.findMissingRanges(nums, lower, upper));  // Output: [[2, 2], [4, 49], [51, 74], [76, 99]]
    }
}
