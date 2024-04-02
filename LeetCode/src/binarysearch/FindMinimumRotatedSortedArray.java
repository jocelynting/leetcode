package binarysearch;

public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

    /*
        左值 < 中值, 中值 < 右值 ：没有旋转，最小值在最左边，可以收缩右边界
        1 2 3 4 5
        左值 > 中值, 中值 < 右值 ：有旋转，最小值在左半边，可以收缩右边界
        5 1 2 3 4    4 5 1 2 3
        左值 < 中值, 中值 > 右值 ：有旋转，最小值在右半边，可以收缩左边界
        3 4 5 1 2    2 3 4 5 1
        左值 > 中值, 中值 > 右值 ：单调递减，不可能出现
     */

//        int left = 0, right = nums.length - 1;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//
//            if (nums[mid] <= nums[right]) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray solution = new FindMinimumRotatedSortedArray();
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test case 1: " + solution.findMin(nums1)); // Output: 1
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test case 2: " + solution.findMin(nums2)); // Output: 0
        int[] nums3 = {3, 1, 2};
        System.out.println("Test case 3: " + solution.findMin(nums3)); // Output: 1
    }
}
