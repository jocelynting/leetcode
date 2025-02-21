package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> results = new ArrayList<>();

        int index = 0;
        int length = intervals.length;

        while (index < length && intervals[index][1] < newInterval[0]) {
            results.add(intervals[index]);
            index++;
        }

        while (index < length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        results.add(newInterval);

        while (index < length) {
            results.add(intervals[index]);
            index++;
        }

        return results.toArray(new int[results.size()][2]);
    }

    // Test the solution
    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println(Arrays.deepToString(solution.insert(intervals1, newInterval1)));
        // Output: [[1,5],[6,9]]

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println(Arrays.deepToString(solution.insert(intervals2, newInterval2)));
        // Output: [[1,2],[3,10],[12,16]]
    }
}
