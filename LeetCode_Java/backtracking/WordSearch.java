package backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(char[][] board, String word, int row, int col, int searchIndex) {
        if (searchIndex == word.length()) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(searchIndex)) {
            return false;
        }

        board[row][col] = '#';

        boolean result = backtracking(board, word, row - 1, col, searchIndex + 1) ||
                backtracking(board, word, row + 1, col, searchIndex + 1) ||
                backtracking(board, word, row, col - 1, searchIndex + 1) ||
                backtracking(board, word, row, col + 1, searchIndex + 1);

        board[row][col] = word.charAt(searchIndex);

        return result;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(solution.exist(board, word1)); // Output: true
        System.out.println(solution.exist(board, word2)); // Output: true
        System.out.println(solution.exist(board, word3)); // Output: false
    }
}
