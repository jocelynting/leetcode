package array;

public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + gain[i - 1];
            result = Math.max(result, prefix[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindHighestAltitude solution = new FindHighestAltitude();
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println(solution.largestAltitude(gain1)); // Output: 1

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(solution.largestAltitude(gain2)); // Output: 0
    }
}
