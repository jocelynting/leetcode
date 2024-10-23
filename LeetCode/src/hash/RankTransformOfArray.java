package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray {

    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int n : sorted) {
            if (!map.containsKey(n)) {
                map.put(n, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        RankTransformOfArray solution = new RankTransformOfArray();
        int[] arr1 = {40, 10, 20, 30};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr1))); // Output: [4, 1, 2, 3]

        int[] arr2 = {100, 100, 100};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr2))); // Output: [1, 1, 1]

        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr3))); // Output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }
}
