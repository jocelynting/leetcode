package graph.floydwarshall;

public class CityWithSmallestNeighbors {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    distance[i][j] = Integer.MAX_VALUE / 2;// 防止加法溢出
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            distance[u][v] = w;
            distance[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int result = -1;
        int min = n;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CityWithSmallestNeighbors solution = new CityWithSmallestNeighbors();

        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        System.out.println(solution.findTheCity(n, edges, distanceThreshold)); // Output: 3

        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        System.out.println(solution.findTheCity(n2, edges2, distanceThreshold2));  // Output: 0
    }
}
