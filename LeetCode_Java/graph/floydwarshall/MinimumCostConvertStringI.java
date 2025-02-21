package graph.floydwarshall;

import java.util.Arrays;

public class MinimumCostConvertStringI {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] distance = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            distance[from][to] = Math.min(distance[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (distance[from][to] == INF) return -1;
            result += distance[from][to];
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumCostConvertStringI solution = new MinimumCostConvertStringI();

        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(solution.minimumCost(source1, target1, original1, changed1, cost1));// Output: 28

        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c',};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(solution.minimumCost(source2, target2, original2, changed2, cost2));// Output: 12
    }

}
