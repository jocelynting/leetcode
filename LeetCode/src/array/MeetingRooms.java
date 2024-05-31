package array;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] first = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] < first[1]) {
                return false;
            }
            first = next;
        }

        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(solution.canAttendMeetings(intervals1));// Output: false
        System.out.println(solution.canAttendMeetings(intervals2));// Output: true
    }
}
