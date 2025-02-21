package array;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {

        int[] count = new int[1001];

        for (int num : nums) {
            count[num]++;
        }

        int max = -1;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            if (c == 1) {
                max = Math.max(max, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LargestUniqueNumber solution = new LargestUniqueNumber();
        int[] nums1 = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        System.out.println(solution.largestUniqueNumber(nums1));// Output: 8

        int[] nums2 = {9, 9, 8, 8};
        System.out.println(solution.largestUniqueNumber(nums2));// Output: -1
    }
}
