package binarysearch;

public class KoKoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = 1;
        for (int pile: piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateHour(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int calculateHour(int[] piles, int k) {
        int hour = 0;
        for (int pile: piles) {
            hour += pile / k;
            if (pile % k > 0) {
                hour++;
            }
        }

        return hour;
    }

    public static void main(String[] args) {
        KoKoEatingBanana solution = new KoKoEatingBanana();
        int[] piles = {3, 6, 7, 11};
        int H = 8;
        System.out.println("Minimum eating speed: " + solution.minEatingSpeed(piles, H)); // Output: 4
    }
}
