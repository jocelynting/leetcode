package array;

import java.util.Arrays;

public class MaximizeHappinessSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int n = happiness.length;
        int count = 0;
        long sum = 0;
        for (int i = n - 1; i > n - k - 1; i--) {
            if (happiness[i] - count > 0) {
                sum += happiness[i] - count;
                count++;
            } else {
                break;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        MaximizeHappinessSelectedChildren solution = new MaximizeHappinessSelectedChildren();
        int[] happiness1 = {1,2,3};
        int k1 = 2;
        int[] happiness2 = {1,1,1,1};
        int k2 = 2;
        int[] happiness3 = {2,3,4,5};
        int k3 = 1;

        System.out.println(solution.maximumHappinessSum(happiness1, k1));// Output: 4
        System.out.println(solution.maximumHappinessSum(happiness2, k2));// Output: 1
        System.out.println(solution.maximumHappinessSum(happiness3, k3));// Output: 5

    }
}
