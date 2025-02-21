package twopoint;

public class ShortestSubarrayRemovedMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return 0;
        }

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int result = Math.min(n - left - 1, right);

        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestSubarrayRemovedMakeArraySorted solution = new ShortestSubarrayRemovedMakeArraySorted();
        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(solution.findLengthOfShortestSubarray(arr1));// Output: 3

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(solution.findLengthOfShortestSubarray(arr2));// Output: 4

    }
}
