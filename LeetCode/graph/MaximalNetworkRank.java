package graph;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] connect = new boolean[n][n];

        for (int[] road : roads) {
            int r1 = road[0];
            int r2 = road[1];
            degree[r1]++;
            degree[r2]++;
            connect[r1][r2] = true;
            connect[r2][r1] = true;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cur = degree[i] + degree[j];
                if (connect[i][j]) {
                    cur--;
                }
                max = Math.max(max, cur);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximalNetworkRank solution = new MaximalNetworkRank();

        int n1 = 4;
        int[][] roads1 = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(solution.maximalNetworkRank(n1, roads1)); // Output: 4

        int n2 = 5;
        int[][] roads2 = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.maximalNetworkRank(n2, roads2)); // Output: 4

        int n3 = 8;
        int[][] roads3 = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
        System.out.println(solution.maximalNetworkRank(n3, roads3)); // Output: 5
    }
}
