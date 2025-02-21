package graph.dijkstra;

import java.util.*;

public class MinimumCostConvertStringI {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
        }

        long[][] minCosts = new long[26][26];
        for (int i = 0; i < 26; i++) {
            minCosts[i] = dijkstra(graph, i);
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (from != to) {
                if (minCosts[from][to] == Long.MAX_VALUE) {
                    return -1;
                }
                result += minCosts[from][to];
            }
        }
        return result;
    }

    private long[] dijkstra(Map<Integer, List<int[]>> graph, int source) {
        long[] distances = new long[26];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{source, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d > distances[u]) continue;

            List<int[]> neighbors = graph.getOrDefault(u, Collections.emptyList());
            for (int[] edge : neighbors) {
                int v = edge[0];
                long w = edge[1];
                if (d + w < distances[v]) {
                    distances[v] = d + w;
                    pq.offer(new long[]{v, distances[v]});
                }
            }
        }

        return distances;
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
