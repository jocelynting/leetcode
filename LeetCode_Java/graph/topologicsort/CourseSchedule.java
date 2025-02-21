package graph.topologicsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int preCourse = pre[1];
            int nextCourse = pre[0];
            graph.get(preCourse).add(nextCourse);
            indegrees[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int course = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            course++;
            for (int nei : graph.get(cur)) {
                indegrees[nei]--;
                if (indegrees[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return course == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean result = solution.canFinish(numCourses, prerequisites);// Output: true
        System.out.println("Can finish all courses: " + result);
    }
}
