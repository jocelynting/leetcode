package binarysearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / cols][mid % cols];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target1 = 3;
        System.out.println(solution.searchMatrix(matrix1, target1)); // Output: true

        int target2 = 13;
        System.out.println(solution.searchMatrix(matrix1, target2)); // Output: false

        int[][] matrix2 = {
                {1, 3}
        };

        int target3 = 3;
        System.out.println(solution.searchMatrix(matrix2, target3)); // Output: true

        int target4 = 2;
        System.out.println(solution.searchMatrix(matrix2, target4)); // Output: false
    }
}
