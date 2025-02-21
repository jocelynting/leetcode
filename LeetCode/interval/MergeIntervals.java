package interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> results = new LinkedList<>();

        for (int[] interval: intervals) {
            if (results.isEmpty() || results.getLast()[1] < interval[0]) {
                results.add(interval);
            } else {
                results.getLast()[1] = Math.max(interval[1], results.getLast()[1]);
            }
        }

        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        // Test Case 1
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged1 = solution.merge(intervals1);
        solution.printArray(merged1); // Output: [[1,6],[8,10],[15,18]]

        // Test Case 2
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] merged2 = solution.merge(intervals2);
        solution.printArray(merged2); // Output: [[1,5]]

        // Test Case 3
        int[][] intervals3 = {{1,4},{2,3}};
        int[][] merged3 = solution.merge(intervals3);
        solution.printArray(merged3); // Output: [[1,4]]
    }

    private void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
