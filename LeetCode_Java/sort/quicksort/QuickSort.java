package sort.quicksort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            System.out.println("Pivot:" + pivot);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, r);
        System.out.println("Partition Array:" + Arrays.toString(nums));
        return p;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] nums = {3, 2, 1, 5, 6};
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
