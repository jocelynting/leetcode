package graph;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfGoodNodes {
    int count;

    public int countGoodNodes(int[][] edges) {
        count = 0;
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1, graph);

        return count;
    }

    private int dfs(int node, int parent, List<List<Integer>> graph) {
        int size = 1;
        int subtreeSize = -1;
        boolean isGood = true;

        for (int child : graph.get(node)) {
            if (child != parent) {
                int childSize = dfs(child, node, graph);
                if (subtreeSize == -1) {
                    subtreeSize = childSize;
                } else if (subtreeSize != childSize) {
                    isGood = false;
                }
                size += childSize;
            }
        }

        if (isGood) {
            count++;
        }

        return size;
    }

    public static void main(String[] args) {
        CountNumberOfGoodNodes solution = new CountNumberOfGoodNodes();
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        System.out.println(solution.countGoodNodes(edges1));// Output: 7

        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}};
        System.out.println(solution.countGoodNodes(edges2));// Output: 6
    }
}

