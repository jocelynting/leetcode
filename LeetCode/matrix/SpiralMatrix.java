package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {

            for (int i = left; i < right; i++) {
                int num = matrix[top][i];
                result.add(num);
            }
            top++;

            for (int i = top; i < bottom; i++) {
                int num = matrix[i][right - 1];
                result.add(num);
            }
            right--;

            if (left >= right || top >= bottom) {
                break;
            }

            for (int i = right - 1; i >= left; i--) {
                int num = matrix[bottom - 1][i];
                result.add(num);
            }
            bottom--;

            for (int i = bottom - 1; i >= top; i--) {
                int num = matrix[i][left];
                result.add(num);
            }
            left++;

        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println("Spiral order traversal: " + result);
        //Output: [1,2,3,6,9,8,7,4,5]
    }

}
