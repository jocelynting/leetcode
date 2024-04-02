package array;

import java.util.Arrays;

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];

        for (int[] book: bookings) {
            int first = book[0] - 1;
            int last = book[1] - 1;
            int seat = book[2];

             seats[first] += seat;
            if (last + 1 < n) {
                seats[last + 1] -= seat;
            }
        }

        for (int i = 1; i < n; i++) {
            seats[i] += seats[i - 1];
        }

        return seats;
    }

    public static void main(String[] args) {
        CorporateFlightBookings solution = new CorporateFlightBookings();

        // Test case
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        // Expected output: [10, 55, 45, 25, 25]
        int[] result = solution.corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(result));
    }
}
