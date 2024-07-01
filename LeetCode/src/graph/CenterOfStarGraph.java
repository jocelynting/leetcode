package graph;

public class CenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CenterOfStarGraph solution = new CenterOfStarGraph();
        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}};
        int[][] edges2 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};

        System.out.println(solution.findCenter(edges1)); // Output: 2
        System.out.println(solution.findCenter(edges2)); // Output: 1
    }
}
