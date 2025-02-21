package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumIntervalIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] - a[0] + 1));

        int index = 0;
        for (int[] query : sortedQueries) {
            int q = query[0], i = query[1];

            while (index < intervals.length && intervals[index][0] <= q) {
                pq.offer(intervals[index]);
                index++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int[] small = pq.peek();
                result[i] = small[1] - small[0] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumIntervalIncludeEachQuery solution = new MinimumIntervalIncludeEachQuery();
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        int[] result = solution.minInterval(intervals, queries);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 1, 4]
    }
}
