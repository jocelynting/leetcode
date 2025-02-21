package hash;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test cases
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("Does nums1 contain duplicates? " + solution.containsDuplicate(nums1)); // Output: true
        System.out.println("Does nums2 contain duplicates? " + solution.containsDuplicate(nums2)); // Output: false
        System.out.println("Does nums3 contain duplicates? " + solution.containsDuplicate(nums3)); // Output: true
    }
}
