package twopoint;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r; i++) {
            while (nums[i] == 2 && i < r) {
                swap(nums, i, r);
                r--;
            }
            while (nums[i] == 0 && i > l) {
                swap(nums, i, l);
                l++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors();

        // Test case
        int[] colors = {2, 0, 2, 1, 1, 0};
        solution.sortColors(colors);
        System.out.println("Sorted colors: " + Arrays.toString(colors));
    }

}
