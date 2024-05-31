package dp;

import java.util.*;

public class MaximumProfitInJobScheduling {

    class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            // 包含当前工作的利润
            int includeProfit = jobs[i].profit;
            // 找到不与当前工作重叠的最后一个工作
            int l = findLastNonConflict(jobs, i);
            if (l != -1) {
                includeProfit += dp[l];
            }
            // 最大利润是包含当前工作和不包含当前工作的最大值
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    private int findLastNonConflict(Job[] jobs, int index) {
        int left = 0, right = index - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();
        int[] startTime1 = {1, 2, 3, 3};
        int[] endTime1 = {3, 4, 5, 6};
        int[] profit1 = {50, 10, 40, 70};
        System.out.println(solution.jobScheduling(startTime1, endTime1, profit1)); // Output: 120

        int[] startTime2 = {1, 2, 3, 4, 6};
        int[] endTime2 = {3, 5, 10, 6, 9};
        int[] profit2 = {20, 20, 100, 70, 60};
        System.out.println(solution.jobScheduling(startTime2, endTime2, profit2)); // Output: 150

        int[] startTime3 = {1, 1, 1};
        int[] endTime3 = {2, 3, 4};
        int[] profit3 = {5, 6, 4};
        System.out.println(solution.jobScheduling(startTime3, endTime3, profit3)); // Output: 6
    }
}
