package binarysearch;

public class FirstAndLastElementPosition {

    public int[] searchRange(int[] nums, int target) {

        int first = binarySearch(nums, target, true);

        if (first == -1) return new int[] {-1, -1};

        int second = binarySearch(nums, target, false);

        return new int[] {first, second};
    }

    private int binarySearch(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (first) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        if (first) {
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        } else {
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }

    public static void main(String[] args) {
        FirstAndLastElementPosition solution = new FirstAndLastElementPosition();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and Last Position of " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
