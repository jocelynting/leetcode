package binarysearch;

public class MinimumNumberDaysMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int left = 0, right = 0;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int flowers = 0, bouquets = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

        }

        return bouquets >= m;
    }

    public static void main(String[] args) {
        MinimumNumberDaysMakeBouquets solution = new MinimumNumberDaysMakeBouquets();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(solution.minDays(bloomDay, m, k));  // Output: 3

        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println(solution.minDays(bloomDay2, m2, k2));  // Output: -1

        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println(solution.minDays(bloomDay3, m3, k3));  // Output: 12

        int[] bloomDay4 = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int m4 = 4, k4 = 2;
        System.out.println(solution.minDays(bloomDay4, m4, k4));  // Output: 9
    }
}
