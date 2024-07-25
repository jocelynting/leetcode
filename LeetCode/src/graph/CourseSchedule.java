package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int preCourse = pre[1];
            int nextCourse = pre[0];
            graph.get(preCourse).add(nextCourse);
        }

        /*
         * 借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
         * 未被 DFS 访问：i == 0；
         * 已被其他节点启动的 DFS 访问：i == -1；
         * 已被当前节点启动的 DFS 访问：i == 1。
         */
        int[] flags = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            boolean result = dfs(graph, flags, i);
            if (!result) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] flags, int course) {

        if (flags[course] == 1) return false;
        if (flags[course] == -1) return true;

        flags[course] = 1;

        for (Integer pre : graph.get(course)) {
            if (!dfs(graph, flags, pre)) {
                return false;
            }
        }

        flags[course] = -1;

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean result = solution.canFinish(numCourses, prerequisites);// Output: true
        System.out.println("Can finish all courses: " + result);
    }
}
