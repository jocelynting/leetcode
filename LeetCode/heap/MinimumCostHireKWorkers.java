package heap;

import java.util.*;

public class MinimumCostHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        List<double[]> ratios = new ArrayList<>();

        for (int i = 0; i < quality.length; i++) {
            ratios.add(new double[]{quality[i], (double)wage[i] / (double)quality[i]});
        }

        // sort by wage[i] / quality[i]
        ratios.sort((a, b) -> Double.compare(a[1], b[1]));

        // sort by quality
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        double minCost = Double.MAX_VALUE;
        double totalQuality = 0;

        for (double[] ratio : ratios) {
            double q = ratio[0];
            double r = ratio[1];

            maxHeap.offer(ratio);
            totalQuality += q;

            if (maxHeap.size() > k) {
                double[] maxQuality = maxHeap.poll();
                totalQuality -= maxQuality[0];
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, r * totalQuality);
            }
        }

        return minCost;
    }
    public static void main(String[] args) {
        MinimumCostHireKWorkers solution = new MinimumCostHireKWorkers();

        // Test case 1
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        double result = solution.mincostToHireWorkers(quality, wage, k);
        System.out.println(result);// Output: 105.00000;

        // Test case 2
        quality = new int[]{3, 1, 10, 10, 1};
        wage = new int[]{4, 8, 2, 2, 7};
        k = 3;
        result = solution.mincostToHireWorkers(quality, wage, k);
        System.out.println(result);// Output: 30.66667;
    }
}
