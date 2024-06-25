package greedy;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxFreqCount = 1;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq) {
                break;
            }
            maxFreqCount++;
        }

        int maxIntervals = (maxFreq - 1) * (n + 1) + maxFreqCount;

        return Math.max(tasks.length, maxIntervals);
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
