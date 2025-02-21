package array;

import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        // Test Case 1
        int[] nums1 = {1, 1, 2};
        System.out.println("Test Case 1:");
        System.out.println("Original Array: " + Arrays.toString(nums1));
        int len1 = solution.removeDuplicates(nums1);
        System.out.println("Length after removal: " + len1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, len1)));

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nTest Case 2:");
        System.out.println("Original Array: " + Arrays.toString(nums2));
        int len2 = solution.removeDuplicates(nums2);
        System.out.println("Length after removal: " + len2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, len2)));
    }
}
