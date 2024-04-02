package array;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];

        for (int[] trip: trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            timestamp[start] += passengers;
            timestamp[end] -= passengers;
        }

        int totalPassengers = 0;
        for (int p: timestamp) {
            totalPassengers += p;
            if (totalPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CarPooling solution = new CarPooling();

        // Test case: trips = [[2,1,5],[3,3,7]], capacity = 4
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        // Expected output: false
        System.out.println(solution.carPooling(trips1, capacity1));

        // Test case: trips = [[2,1,5],[3,3,7]], capacity = 5
        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        // Expected output: true
        System.out.println(solution.carPooling(trips2, capacity2));
    }
}
