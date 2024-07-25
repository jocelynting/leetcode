package sort.mergeSort;

import java.util.Arrays;

public class SortArray {

    public int[] sortArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        SortArray solution = new SortArray();

        int[] nums1 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(solution.sortArray(nums1)));// Output: [1,2,3,5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(solution.sortArray(nums2)));// Output: [0,0,1,1,2,5]
    }
}
