package array;

import java.util.Arrays;

public class SpecialArrayII {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int n = nums.length;
        int[] special = new int[n - 1];
        int[] prefixSpecial = new int[n];

        for (int i = 0; i < n - 1; i++) {
            special[i] = nums[i] % 2 == nums[i + 1] % 2 ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            prefixSpecial[i] = prefixSpecial[i - 1] + special[i - 1];
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            result[i] = prefixSpecial[to] - prefixSpecial[from] == 0;
        }

        return result;
    }
    public static void main(String[] args) {
        SpecialArrayII solution = new SpecialArrayII();
        int[] nums1 = {3,4,1,2,6};
        int[][] queries1 = {{0,4}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums1, queries1))); // Output: [false]
        int[] nums2 = {4,3,1,6};
        int[][] queries2 = {{0,2}, {2,3}};
        System.out.println(Arrays.toString(solution.isArraySpecial(nums2, queries2))); // Output: [false,true]
    }
}
