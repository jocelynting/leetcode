package binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        // Test cases
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int target2 = 2;

        System.out.println("Index of target 9: " + solution.search(nums, target1)); // Output: 4
        System.out.println("Index of target 2: " + solution.search(nums, target2)); // Output: -1
    }
}
