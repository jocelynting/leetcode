package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[][] reachable = new boolean[numCourses][numCourses];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nei : graph.get(cur)) {
                reachable[cur][nei] = true;
                for (int i = 0; i < numCourses; i++) {
                    if (reachable[i][cur]) {
                        reachable[i][nei] = true;
                    }
                }
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        List<Boolean> results = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            results.add(reachable[u][v]);
        }

        return results;
    }

    public static void main(String[] args) {
        CourseScheduleIV solution = new CourseScheduleIV();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{0, 1}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(solution.checkIfPrerequisite(numCourses1, prerequisites1, queries1));
        // Output: [true, false]

        int numCourses2 = 5;
        int[][] prerequisites2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries2 = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        System.out.println(solution.checkIfPrerequisite(numCourses2, prerequisites2, queries2));
        // Output: [true, false, true, false]
    }

}
