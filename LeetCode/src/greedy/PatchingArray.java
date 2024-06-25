package greedy;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long num = 1;
        int added = 0;
        int i = 0;

        while (num <= n) {
            if (i < nums.length && nums[i] <= num) {
                num += nums[i];
                i++;
            } else {
                num += num;
                added++;
            }
        }

        return added;
    }

    public static void main(String[] args) {
        PatchingArray solution = new PatchingArray();

        int[] nums1 = {1, 3};
        int n1 = 6;
        System.out.println(solution.minPatches(nums1, n1));  // Output: 1

        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        System.out.println(solution.minPatches(nums2, n2));  // Output: 2

        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        System.out.println(solution.minPatches(nums3, n3));  // Output: 0
    }
}
