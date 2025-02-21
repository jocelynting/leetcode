package array;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] max = new int[n];
        int[] min = new int[n];

        // Initialize the maxLeft and minRight arrays
        max[0] = arr[0];
        min[n - 1] = arr[n - 1];

        // Fill maxLeft array
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }

        // Fill minRight array
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], arr[i]);
        }

        // Determine the number of chunks
        int chunks = 0;
        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                chunks++;
            }
        }

        // Return the result, chunks + 1 as we have one more chunk after the last partition point
        return chunks + 1;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII solution = new MaxChunksToMakeSortedII();

        int[] arr1 = {5, 4, 3, 2, 1};
        System.out.println(solution.maxChunksToSorted(arr1)); // Output: 1

        int[] arr2 = {2, 1, 3, 4, 4};
        System.out.println(solution.maxChunksToSorted(arr2)); // Output: 4

        int[] arr3 = {1, 0, 1, 3, 2};
        System.out.println(solution.maxChunksToSorted(arr3)); // Output: 3
    }
}
