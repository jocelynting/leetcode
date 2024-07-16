package greedy;

import java.util.Arrays;

public class MinimumCostCuttingCakeII {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        long result = 0;
        int i = m - 2;
        int j = n - 2;
        int cntH = 1;
        int cntV = 1;

        while (i >= 0 || j >= 0) {
            if (j < 0 || i >= 0 && horizontalCut[i] > verticalCut[j]) {
                result += horizontalCut[i--] * cntH;
                cntV++;
            } else {
                result += verticalCut[j--] * cntV;
                cntH++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumCostCuttingCakeII solution = new MinimumCostCuttingCakeII();
        System.out.println(solution.minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));// Output: 13
        System.out.println(solution.minimumCost(2, 2, new int[]{7}, new int[]{4}));// Output: 15
    }
}
