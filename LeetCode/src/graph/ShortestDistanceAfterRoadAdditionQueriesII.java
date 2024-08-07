package graph;

import java.util.Arrays;
import java.util.TreeSet;

public class ShortestDistanceAfterRoadAdditionQueriesII {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> edges = new TreeSet<>();
        for (int i = 0; i < n - 1; i++) {
            edges.add(i);
        }

        int length = queries.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int u = queries[i][0], v = queries[i][1];
            edges.subSet(u, false, v, false).clear();
            result[i] = edges.size();
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesII solution = new ShortestDistanceAfterRoadAdditionQueriesII();
        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n1, queries1)));// Output: [3,2,1]

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n2, queries2)));// Output: [1,1]
    }
}
