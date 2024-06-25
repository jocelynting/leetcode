package twopoint;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int partition = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, partition - 1);
        reverse(nums, partition, n - 1);

    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4
    }
}
