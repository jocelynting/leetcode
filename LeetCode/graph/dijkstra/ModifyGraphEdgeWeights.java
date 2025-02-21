package graph.dijkstra;

import java.util.*;

public class ModifyGraphEdgeWeights {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w != -1) {
                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
            }
        }

        int shortest = dijkstra(graph, n, source, destination);
        if (shortest < target) {
            return new int[0][0];
        }

        boolean match = shortest == target;
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                continue;
            }
            edge[2] = match ? 1000000000 : 1;
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});

            if (!match) {
                int next = dijkstra(graph, n, source, destination);
                if (next <= target) {
                    match = true;
                    edge[2] += target - next;
                }
            }
        }

        return match ? edges : new int[0][0];
    }

    private int dijkstra(Map<Integer, List<int[]>> graph, int n, int source, int destination) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{source, 0});

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (d > distance[u]) {
                continue;
            }

            if (graph.containsKey(u)) {
                for (int[] nei : graph.get(u)) {
                    int v = nei[0];
                    int w = nei[1];
                    if (distance[v] > d + w) {
                        distance[v] = d + w;
                        pq.offer(new int[]{v, distance[v]});
                    }
                }
            }

        }

        return distance[destination];
    }

    public static void main(String[] args) {
        ModifyGraphEdgeWeights solution = new ModifyGraphEdgeWeights();
        int n1 = 5;
        int[][] edges1 = {{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}};
        int source1 = 0, destination1 = 1, target1 = 5;
        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(n1, edges1, source1, destination1, target1)));
        // Output: [[4,1,1],[2,0,1],[0,3,3],[4,3,1]]

        int n2 = 3;
        int[][] edges2 = {{0, 1, -1}, {0, 2, 5}};
        int source2 = 0, destination2 = 2, target2 = 6;
        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(n2, edges2, source2, destination2, target2)));
        // Output: []

        int n3 = 4;
        int[][] edges3 = {{1, 0, 4}, {1, 2, 3}, {2, 3, 5}, {0, 3, -1}};
        int source3 = 0, destination3 = 2, target3 = 6;
        System.out.println(Arrays.deepToString(solution.modifiedGraphEdges(n3, edges3, source3, destination3, target3)));
        // Output: [[1,0,4],[1,2,3],[2,3,5],[0,3,1]]
    }
}
