package graph;

public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        int result = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                result = i;
            }
        }

        return count > 1 ? -1 : result;
    }

    public static void main(String[] args) {
        FindChampionII solution = new FindChampionII();
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(solution.findChampion(3, edges1)); // Output: 0

        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(solution.findChampion(4, edges2)); // Output: -1
    }
}
