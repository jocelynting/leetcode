package binarysearch;

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;
        double left = 0, right = 1;
        int[] result = new int[2];

        while (left < right) {
            double mid = left + (right - left) / 2;
            double maxFraction = 0;
            int count = 0;
            result[0] = 0;
            result[1] = 1;

            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += n - j;
                if (j < n && arr[i] * result[1] > result[0] * arr[j]) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }

            if (count == k) {
                return result;
            } else if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction solution = new KthSmallestPrimeFraction();
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] result = solution.kthSmallestPrimeFraction(arr, k);
        System.out.println("Fraction: " + result[0] + "/" + result[1]); // Output: Fraction: 2/5
    }
}
