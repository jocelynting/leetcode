package binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
//        return oneBinarySearch(nums, target);
        return pivotAndBinarySearch(nums, target);
    }

    private int pivotAndBinarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        // find pivot
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int result = binarySearch(nums, target, 0, left - 1);

        return result != -1 ? result : binarySearch(nums, target, left, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int l = left, r = right;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private int oneBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // left is sorted array
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // right is sorted array
                if (target < nums[right] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target: " + solution.search(nums, target)); // Output: 4
    }
}
