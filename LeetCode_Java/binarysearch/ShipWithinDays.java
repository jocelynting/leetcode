package binarysearch;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateDays(weights, mid) <= days){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int calculateDays(int[] weights, int capacity) {
        int day = 0;
        int total = 0;

        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                day++;
                total = weight;
            }
        }

        if (total > 0) {
            day++;
        }

        return day;
    }

    public static void main(String[] args) {
        ShipWithinDays solution = new ShipWithinDays();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(solution.shipWithinDays(weights, D)); // Output should be 15
    }
}
