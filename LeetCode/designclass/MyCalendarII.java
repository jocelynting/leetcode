package designclass;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {

    private List<int[]> calendar;
    private List<int[]> overlap;

    public MyCalendarII() {
        calendar = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] c : overlap) {
            int from = c[0], to = c[1];
            if (Math.max(start, from) < Math.min(end, to)) {
                return false;
            }
        }

        for (int[] c : calendar) {
            int from = c[0], to = c[1];
            int overlapStart = Math.max(start, from);
            int overlapEnd = Math.min(end, to);
            if (overlapStart < overlapEnd) {
                overlap.add(new int[]{overlapStart, overlapEnd});
            }
        }

        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII solution = new MyCalendarII();
        System.out.println(solution.book(10, 20)); // true
        System.out.println(solution.book(50, 60)); // true
        System.out.println(solution.book(10, 40)); // true
        System.out.println(solution.book(5, 15));  // false
        System.out.println(solution.book(5, 10));  // true
        System.out.println(solution.book(25, 55)); // true
    }
}
