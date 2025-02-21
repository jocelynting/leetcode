package math;

import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int length = rolls.length;
        int total = (length + n) * mean;
        int sum = 0;

        for (int r : rolls) {
            sum += r;
        }

        int rest = total - sum;
        if (rest > 6 * n || rest < n) {
            return new int[0];
        }

        int divide = rest / n;
        int mod = rest % n;
        int[] result = new int[n];

        Arrays.fill(result, divide);
        for (int i = 0; i < mod; i++) {
            result[i]++;
        }

        return result;
    }

    public static void main(String[] args) {
        FindMissingObservations solution = new FindMissingObservations();
        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4;
        int n1 = 2;
        System.out.println(Arrays.toString(solution.missingRolls(rolls1, mean1, n1)));  // Output: [6, 6]

        int[] rolls2 = {1, 5, 6};
        int mean2 = 3;
        int n2 = 4;
        System.out.println(Arrays.toString(solution.missingRolls(rolls2, mean2, n2)));  // Output: [2, 3, 2, 2]

        int[] rolls3 = {1, 2, 3, 4};
        int mean3 = 6;
        int n3 = 4;
        System.out.println(Arrays.toString(solution.missingRolls(rolls3, mean3, n3)));  // Output: []
    }
}
