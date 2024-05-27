package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int count = n;
        while (count > 2) {
            count -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                int nei = graph.get(leaf).iterator().next();
                graph.get(nei).remove(leaf);
                if (graph.get(nei).size() == 1) {
                    newLeaves.add(nei);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();

        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        int n1 = 4;
        System.out.println(solution.findMinHeightTrees(n1, edges1)); // Output: [1]

        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n2 = 6;
        System.out.println(solution.findMinHeightTrees(n2, edges2)); // Output: [3, 4]

        int[][] edges3 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {3, 5}, {3, 6}};
        int n3 = 7;
        System.out.println(solution.findMinHeightTrees(n3, edges3)); // Output: [2]
    }
}
