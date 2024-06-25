package hash;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num - diff * 2)) {
                result++;
            }
            set.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfArithmeticTriplets solution = new NumberOfArithmeticTriplets();
        int[] nums1 = {0, 1, 4, 6, 7, 10};
        int diff1 = 3;
        System.out.println(solution.arithmeticTriplets(nums1, diff1));  // Output: 2

        int[] nums2 = {4, 5, 6, 7, 8, 9};
        int diff2 = 2;
        System.out.println(solution.arithmeticTriplets(nums2, diff2));  // Output: 2
    }
}
