package array;

public class MissingNumber {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int cur = 0;

        for (int num: nums) {
            cur += num;
        }

        return sum - cur;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        // Test cases
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {0, 1};
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Missing number in nums1: " + solution.missingNumber(nums1)); // Output: 2
        System.out.println("Missing number in nums2: " + solution.missingNumber(nums2)); // Output: 2
        System.out.println("Missing number in nums3: " + solution.missingNumber(nums3)); // Output: 8
    }
}
