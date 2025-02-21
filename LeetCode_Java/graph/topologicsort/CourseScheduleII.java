package graph.topologicsort;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int first = pre[1];
            int second = pre[0];
            graph.get(first).add(second);
            indegrees[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index] = cur;
            for (int nei : graph.get(cur)) {
                indegrees[nei]--;
                if (indegrees[nei] == 0) {
                    queue.offer(nei);
                }
            }
            index++;
        }

        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses1, prerequisites1))); // Output: [0, 1]

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses2, prerequisites2))); // Output: [0, 1, 2, 3]
    }
}
