package graph.dijkstra;

import java.util.*;

public class CityWithSmallestNeighbors {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        int result = -1;
        int min = n;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0];
                int d = cur[1];
                if (d > distance[u]) continue;

                if (graph.containsKey(u)) {
                    for (int[] nei : graph.get(u)) {
                        int v = nei[0];
                        int w = nei[1];
                        if (distance[u] + w < distance[v]) {
                            distance[v] = distance[u] + w;
                            pq.offer(new int[]{v, distance[v]});
                        }
                    }
                }

            }

            for (int j = 0; j < n; j++) {
                if (i != j && distance[j] <= distanceThreshold) {
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
