package greedy;

import java.util.Arrays;

public class MinimumNumberMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNumberMovesToSeatEveryone solution = new MinimumNumberMovesToSeatEveryone();

        int[] seats1 = {3, 1, 5};
        int[] students1 = {2, 7, 4};
        System.out.println(solution.minMovesToSeat(seats1, students1)); // Output: 4

        int[] seats2 = {4, 1, 5, 9};
        int[] students2 = {1, 3, 2, 6};
        System.out.println(solution.minMovesToSeat(seats2, students2)); // Output: 7

        int[] seats3 = {2, 2, 6, 6};
        int[] students3 = {1, 3, 2, 6};
        System.out.println(solution.minMovesToSeat(seats3, students3)); // Output: 4
    }
}
