package graph.floydwarshall;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];

        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            reachable[u][v] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
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
