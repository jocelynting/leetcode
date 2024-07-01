package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k; // We use this to avoid out-of-bound issues

        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare the distance of arr[mid] to x and arr[mid + k] to x
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1; // Move left boundary to mid + 1
            } else {
                right = mid; // Move right boundary to mid (or mid + k if needed)
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements solution = new FindKClosestElements();

        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        int x1 = 3;
        List<Integer> result1 = solution.findClosestElements(arr1, k1, x1);
        System.out.println(result1); // Expected output: [1, 2, 3, 4]

        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 4;
        int x2 = -1;
        List<Integer> result2 = solution.findClosestElements(arr2, k2, x2);
        System.out.println(result2); // Expected output: [1, 2, 3, 4]
    }
}
