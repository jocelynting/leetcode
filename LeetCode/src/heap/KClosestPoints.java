package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int x = a[0] * a[0] + a[1] * a[1];
            int y = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(x,y);
        });

        for (int[] p: points) {
            minHeap.offer(p);
        }

        int[][] results = new int[k][2];

        for (int i = 0; i < k; i++) {
            results[i] = minHeap.poll();
        }

        return results;
    }

    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints
                ();
        int[][] points = {{3, 3}, {-2, 4}, {5, -1}};
        int K = 2;
        int[][] result = solution.kClosest(points, K);
        System.out.println("K closest points:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }// Output: [[3,3],[-2,4]]
    }
}
