package array;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left = prefix[i] - nums[i];
            right = prefix[n - 1] - prefix[i];

            if (left == right) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex soltuion = new FindPivotIndex();
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(soltuion.pivotIndex(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3};
        System.out.println(soltuion.pivotIndex(nums2)); // Output: -1

        int[] nums3 = {2, 1, -1};
        System.out.println(soltuion.pivotIndex(nums3)); // Output: 0
    }
}
