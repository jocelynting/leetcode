package graph.unionfind;

import java.util.*;

public class NumberOfGoodPaths {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        UnionFind uf = new UnionFind(n);
        int result = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int value = entry.getKey();
            List<Integer> nodes = entry.getValue();

            for (int node : nodes) {
                for (int nei : graph.get(node)) {
                    if (vals[nei] <= value) {
                        uf.union(node, nei);
                    }
                }
            }

            Map<Integer, Integer> path = new HashMap<>();
            for (int node : nodes) {
                int root = uf.find(node);
                path.put(root, path.getOrDefault(root, 0) + 1);
            }

            for (int size : path.values()) {
                result += (size * (size + 1)) / 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfGoodPaths solution = new NumberOfGoodPaths();

        int[] vals1 = {1, 3, 2, 1, 3};
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        System.out.println(solution.numberOfGoodPaths(vals1, edges1));// Output: 6

        int[] vals2 = {1, 1, 2, 2, 3};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {2, 4}};
        System.out.println(solution.numberOfGoodPaths(vals2, edges2));// Output: 7
    }
}
