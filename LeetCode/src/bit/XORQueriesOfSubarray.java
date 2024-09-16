package bit;

import java.util.Arrays;

public class XORQueriesOfSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0], to = queries[i][1];
            result[i] = prefixXOR[from] ^ prefixXOR[to + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        XORQueriesOfSubarray solution = new XORQueriesOfSubarray();
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result1 = solution.xorQueries(arr1, queries1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 7, 14, 8]

        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] result2 = solution.xorQueries(arr2, queries2);
        System.out.println(Arrays.toString(result2)); // Output: [8, 0, 4, 4]
    }
}
