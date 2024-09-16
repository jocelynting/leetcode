package array;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            result = Math.min(result, minutes[i + 1] - minutes[i]);
        }

        return Math.min(result, 24 * 60 - minutes[n - 1] + minutes[0]);
    }

    public static void main(String[] args) {
        MinimumTimeDifference solution = new MinimumTimeDifference();
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        System.out.println(solution.findMinDifference(timePoints1)); // Output: 1

        List<String> timePoints2 = Arrays.asList("00:00", "23:59", "12:34");
        System.out.println(solution.findMinDifference(timePoints2)); // Output: 1

        List<String> timePoints3 = Arrays.asList("01:01", "02:01", "03:01", "23:01");
        System.out.println(solution.findMinDifference(timePoints3)); // Output: 60
    }
}
