package designclass;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {

    private List<int[]> calendar;

    public MyCalendarI() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] c : calendar) {
            int from = c[0], to = c[1];
            if (start < to && from < end) {
                return false;
            }
        }

        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarI solution = new MyCalendarI();
        System.out.println(solution.book(10, 20)); // true
        System.out.println(solution.book(15, 25)); // false
        System.out.println(solution.book(20, 30)); // true
    }
}
