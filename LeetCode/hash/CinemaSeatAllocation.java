package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int max = n * 2;

        for (Set<Integer> seats : map.values()) {
            boolean left = canSeatFamily(seats, 2, 3, 4, 5);
            boolean right = canSeatFamily(seats, 6, 7, 8, 9);
            boolean middle = canSeatFamily(seats, 4, 5, 6, 7);

            if (left && right) {

            } else if (left || right || middle) {
                max -= 1;
            } else {
                max -= 2;
            }
        }

        return max;
    }

    private boolean canSeatFamily(Set<Integer> seats, int... cols) {
        for (int col : cols) {
            if (seats.contains(col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CinemaSeatAllocation solution = new CinemaSeatAllocation();

        int n1 = 3;
        int[][] reservedSeats1 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(solution.maxNumberOfFamilies(n1, reservedSeats1)); // Output: 4

        int n2 = 2;
        int[][] reservedSeats2 = {{2, 1}, {1, 8}, {2, 6}};
        System.out.println(solution.maxNumberOfFamilies(n2, reservedSeats2)); // Output: 2
    }
}
