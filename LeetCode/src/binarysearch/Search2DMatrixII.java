package binarysearch;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;

        /*
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] > target) {
                    right = mid;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
         */
    }

    public static void main(String[] args) {
        Search2DMatrixII solution = new Search2DMatrixII();
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println(solution.searchMatrix(matrix1, target1)); // Output: true

        int[][] matrix2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target2 = 20;
        System.out.println(solution.searchMatrix(matrix2, target2)); // Output: false
    }
}
