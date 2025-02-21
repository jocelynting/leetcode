package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] -b[0]);

        List<int[]> merge = new ArrayList<>();

        for (int i = 0; i < meetings.length; i++) {
            int[] cur = meetings[i];
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < cur[0]) {
                merge.add(cur);
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(cur[1],merge.get(merge.size() - 1)[1]);
            }
        }


        int count = 0;

        for (int[] list: merge) {
            count += (list[1] - list[0] + 1);
        }

        return days - count;
    }

    public static void main(String[] args) {
        CountDaysWithoutMeetings solution = new CountDaysWithoutMeetings();

        int days1 = 10;
        int[][] meetings1 = {{5,7},{1,3},{9,10}};
        System.out.println(solution.countDays(days1, meetings1));// Output: 2

        int days2 = 5;
        int[][] meetings2 = {{2,4},{1,3}};
        System.out.println(solution.countDays(days2, meetings2));// Output: 1
    }
}
