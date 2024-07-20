package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        List<Interval> result = new ArrayList<>();

        for (List<Interval> s : schedule) {
            intervals.addAll(s);
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (temp.end < cur.start) {
                result.add(new Interval(temp.end, cur.start));
                temp = cur;
            } else {
                temp.end = Math.max(temp.end, cur.end);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        EmployeeFreeTime solution = new EmployeeFreeTime();

        List<List<Interval>> schedule1 = new ArrayList<>();
        schedule1.add(List.of(new Interval(1, 2), new Interval(5, 6)));
        schedule1.add(List.of(new Interval(1, 3)));
        schedule1.add(List.of(new Interval(4, 10)));

        List<Interval> freeTime1 = solution.employeeFreeTime(schedule1);

        for (Interval interval : freeTime1) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
        // Output: [[3,4]]

        List<List<Interval>> schedule2 = new ArrayList<>();
        schedule2.add(List.of(new Interval(1, 3), new Interval(6, 7)));
        schedule2.add(List.of(new Interval(2, 4)));
        schedule2.add(List.of(new Interval(2, 5), new Interval(9, 12)));

        List<Interval> freeTime2 = solution.employeeFreeTime(schedule2);

        for (Interval interval : freeTime2) {
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        }
        // Output: [[5,6],[7,9]]
    }

}
