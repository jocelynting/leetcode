package hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
//    public boolean isValidSudoku(char[][] board) {
//
//        Set<String> set = new HashSet<>();
//
//        int rows = board.length;
//        int cols = board[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (board[i][j] != '.') {
//                    if (!set.add(board[i][j] + " in row " + i) ||
//                            !set.add(board[i][j] + " in col " + j) ||
//                            !set.add(board[i][j] + " in sub-box " + i / 3 + "-" + j / 3)) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowSeen = new boolean[9];
            boolean[] colSeen = new boolean[9];
            boolean[] boxSeen = new boolean[9];

            for (int j = 0; j < 9; j++) {
                if (!isValid(board[i][j], rowSeen)) {
                    return false;
                }

                if (!isValid(board[j][i], colSeen)) {
                    return false;
                }

                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (!isValid(board[rowIndex][colIndex], boxSeen)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char digit, boolean[] seen) {
        if (digit == '.') {
            return true;
        }
        int index = digit - '1';
        if (seen[index]) {
            return false;
        }
        seen[index] = true;
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        // Test case
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(solution.isValidSudoku(board)); // Expected output: true
    }
}
