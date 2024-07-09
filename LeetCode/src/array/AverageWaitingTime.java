package array;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long total = 0;
        long cur = 0;

        for (int[] customer : customers) {
            int arrive = customer[0];
            int wait = customer[1];

            if (cur < arrive) {
                cur = arrive;
            }

            cur += wait;
            total += (cur - arrive);
        }

        return (double) total / n;
    }

    public static void main(String[] args) {
        AverageWaitingTime solution = new AverageWaitingTime();

        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(solution.averageWaitingTime(customers1)); // Expected output: 5.0

        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(solution.averageWaitingTime(customers2)); // Expected output: 3.25

        int[][] customers3 = {{2, 3}, {6, 3}, {7, 5}, {12, 4}};
        System.out.println(solution.averageWaitingTime(customers3)); // Expected output: 4.5

        int[][] customers4 = {{3, 2}, {5, 4}, {9, 1}};
        System.out.println(solution.averageWaitingTime(customers4)); // Expected output: 3.6666667
    }
}
