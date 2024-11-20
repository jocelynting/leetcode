package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakInArray {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int maxLength = 0;

        for (int n : nums) {
            int length = 0;
            long cur = n;
            while (set.contains((int) cur)) {
                length++;
                cur *= cur;
                if (cur > Integer.MAX_VALUE) {
                    break;
                }
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength >= 2 ? maxLength : -1;
    }

    public static void main(String[] args) {
        LongestSquareStreakInArray solution = new LongestSquareStreakInArray();
        int[] nums = {4, 3, 6, 16, 8, 2};
        System.out.println(solution.longestSquareStreak(nums)); // Output: 3

        int[] nums2 = {2, 3, 5, 6, 7};
        System.out.println(solution.longestSquareStreak(nums2)); // Output: -1
    }
}
