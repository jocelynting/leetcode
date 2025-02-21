package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : taskCounts) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cycle = 0;
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    cur.add(maxHeap.poll());
                    cycle++;
                }
            }

            for (int count: cur) {
                count--;
                if (count > 0) {
                    maxHeap.offer(count);
                }
            }

            time += maxHeap.isEmpty() ? cycle : n + 1;
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println(solution.leastInterval(tasks1, n1)); // Output: 8

        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n2 = 1;
        System.out.println(solution.leastInterval(tasks2, n2)); // Output: 6

        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n3 = 3;
        System.out.println(solution.leastInterval(tasks3, n3)); // Output: 10
    }
}
