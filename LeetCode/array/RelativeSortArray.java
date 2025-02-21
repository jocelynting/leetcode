package array;

import java.util.Arrays;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num: arr1) {
            count[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        for (int num: arr2) {
            while (count[num] > 0) {
                result[index] = num;
                index++;
                count[num]--;
            }
        }

        for (int num = 0; num < count.length; num++) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray solution = new RelativeSortArray();

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1, arr2)));
        // Output: [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]

        int[] arr1_test2 = {28,6,22,8,44,17};
        int[] arr2_test2 = {22,28,8,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1_test2, arr2_test2)));
        // Output: [22, 28, 8, 6, 17, 44]
    }
}
