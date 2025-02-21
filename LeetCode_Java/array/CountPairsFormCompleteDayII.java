package array;

public class CountPairsFormCompleteDayII {
    public long countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        long res = 0;

        for (int hour : hours) {
            int mod = hour % 24;
            res += count[(24 - mod) % 24];
            count[mod]++;
        }

        return res;
    }

    public static void main(String[] args) {
        CountPairsFormCompleteDayII solution = new CountPairsFormCompleteDayII();
        int[] hours1 = {12, 12, 30, 24, 24};
        int[] hours2 = {72, 48, 24, 3};
        System.out.println(solution.countCompleteDayPairs(hours1)); // Output: 2
        System.out.println(solution.countCompleteDayPairs(hours2)); // Output: 3
    }
}
