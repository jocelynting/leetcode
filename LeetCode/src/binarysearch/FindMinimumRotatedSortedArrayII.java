package binarysearch;

public class FindMinimumRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArrayII solution = new FindMinimumRotatedSortedArrayII();
        int[] nums1 = {3, 1, 3}; // Rotated sorted array with duplicates
        System.out.println("Minimum element: " + solution.findMin(nums1)); // Output: 1
        int[] nums2 = {2, 2, 2, 0, 1}; // Rotated sorted array with duplicates
        System.out.println("Minimum element: " + solution.findMin(nums2)); // Output: 0
    }
}
