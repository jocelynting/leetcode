package array;


import java.util.ArrayList;
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

        // Test Case 1
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        System.out.println("Test Case 1:");
        System.out.println("Original Intervals:");
        solution.printIntervals(intervals1);
        System.out.println("New Interval: [" + newInterval1[0] + "," + newInterval1[1] + "]");
        int[][] result1 = solution.insert(intervals1, newInterval1);
        System.out.println("Merged Intervals:");
        solution.printIntervals(result1);// Output: [[1,5],[6,9]]

        // Test Case 2
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        System.out.println("\nTest Case 2:");
        System.out.println("Original Intervals:");
        solution.printIntervals(intervals2);
        System.out.println("New Interval: [" + newInterval2[0] + "," + newInterval2[1] + "]");
        int[][] result2 = solution.insert(intervals2, newInterval2);
        System.out.println("Merged Intervals:");
        solution.printIntervals(result2); // Output: [[1,2],[3,10],[12,16]]
    }

    public void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }
}
