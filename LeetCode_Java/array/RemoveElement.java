package array;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        // Test Case 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Original Array: " + Arrays.toString(nums1));
        int len1 = solution.removeElement(nums1, val1);
        System.out.println("Length after removal: " + len1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, len1)));

        // Test Case 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println("\nTest Case 2:");
        System.out.println("Original Array: " + Arrays.toString(nums2));
        int len2 = solution.removeElement(nums2, val2);
        System.out.println("Length after removal: " + len2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, len2)));
    }
}
