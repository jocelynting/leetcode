package twopoint;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int maxProfit = 0;
        int totalProfit = 0;
        int index = 0;

        for (int w : worker) {
            while (index < n && w >= jobs[index][0]) {
                maxProfit = Math.max(maxProfit, jobs[index][1]);
                index++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;

    }

    public static void main(String[] args) {
        MostProfitAssigningWork solution = new MostProfitAssigningWork();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};

        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker)); // Output：100
    }
}
