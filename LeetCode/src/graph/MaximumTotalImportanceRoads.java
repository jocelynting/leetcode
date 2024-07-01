package graph;

import java.util.Arrays;

public class MaximumTotalImportanceRoads {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);

        long value = 1;
        long result = 0;
        for (long d : degree) {
            result += (value * d);
            value++;
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumTotalImportanceRoads solution = new MaximumTotalImportanceRoads();
        int[][] road1 = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        int n1 = 5;
        System.out.println(solution.maximumImportance(n1, road1)); // Output: 43

        int[][] road2 = {{0, 3}, {2, 4}, {1, 3}};
        int n2 = 5;
        System.out.println(solution.maximumImportance(n2, road2)); // Output: 20
    }
}
