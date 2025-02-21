package twopoint;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        solution.moveZeroes(nums1);
        solution.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums1));// Output: [1,3,12,0,0]
        System.out.println(Arrays.toString(nums2));// Output: [0]
    }
}
