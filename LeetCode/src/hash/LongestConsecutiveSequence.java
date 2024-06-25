package hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int length = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    length++;
                }

                result = Math.max(result, length);

            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));  // Output：4
    }
}
