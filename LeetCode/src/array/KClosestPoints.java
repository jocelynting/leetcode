package array;

import java.util.Arrays;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {

        int n = points.length;

        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = value(points[i]);
        }

        Arrays.sort(distance);

        int[][] result = new int[k][2];
        int index = 0;
        int kValue = distance[k - 1];

        for (int i = 0; i < n; i++) {
            if (value(points[i]) <= kValue) {
                result[index] = points[i];
                index++;
            }
        }

        return result;
    }

    private int value(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints();
        int[][] points = {{3, 3}, {-2, 4}, {5, -1}};
        int K = 2;
        int[][] result = solution.kClosest(points, K);
        System.out.println("K closest points:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }// Output: [[3,3],[-2,4]]
    }
}
