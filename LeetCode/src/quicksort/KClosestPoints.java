package quicksort;

import java.util.Arrays;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {

        quickSort(points, 0, points.length - 1);

        return Arrays.copyOf(points,k);
    }

    private void quickSort(int[][] points, int l, int r) {
        if (l < r) {
            int pivot = partition(points, l, r);
            quickSort(points, l, pivot - 1);
            quickSort(points, pivot + 1, r);
        }
    }

    private int partition(int[][] points, int l, int r) {
        int pivot = pivotValue(points[r]);
        int p = l;

        for (int i = l; i < r; i++) {
            if (pivotValue(points[i]) <= pivot) {
                swap(points,i,p);
                p++;
            }
        }

        swap(points,p,r);
        return p;
    }

    private int pivotValue(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][]points, int p1, int p2) {
        int[] temp = points[p1];
        points[p1] = points[p2];
        points[p2] = temp;
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