package hash;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }

    public static void main(String[] args) {
        KeepMultiplyingFoundValuesByTwo solution = new KeepMultiplyingFoundValuesByTwo();
        int[] nums1 = {5, 3, 6, 1, 12};
        int original1 = 3;
        System.out.println(solution.findFinalValue(nums1, original1)); // Output: 24

        int[] nums2 = {2, 7, 9};
        int original2 = 4;
        System.out.println(solution.findFinalValue(nums2, original2)); // Output: 4

        int[] nums3 = {2};
        int original3 = 2;
        System.out.println(solution.findFinalValue(nums3, original3)); // Output: 4
    }
}
