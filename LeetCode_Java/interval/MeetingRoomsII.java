package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(intervals[i][1]);
        }

        return heap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};

        System.out.println(solution.minMeetingRooms(intervals1)); // Output: 2
        System.out.println(solution.minMeetingRooms(intervals2)); // Output: 1
    }
}
