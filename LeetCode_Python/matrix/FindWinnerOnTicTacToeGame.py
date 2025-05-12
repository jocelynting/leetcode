class FindWinnerOnTicTacToeGame:
    def tictactoe(self, moves: list[list[int]]) -> str:
        rows = [0] * 3
        cols = [0] * 3
        diag = anti_diag = 0

        for i, (row, col) in enumerate(moves):
            player = 1 if i % 2 == 0 else -1

            rows[row] += player
            cols[col] += player

            if row == col:
                diag += player
            if row + col == 2:
                anti_diag += player

            if (
                abs(rows[row]) == 3
                or abs(cols[col]) == 3
                or abs(diag) == 3
                or abs(anti_diag) == 3
            ):
                return "A" if player == 1 else "B"

        return "Draw" if len(moves) == 9 else "Pending"


# Time Complexity: O(1), since the maximum number of moves is 9.
# Space Complexity: O(1), since we are using a fixed amount of space for rows, cols, diag, and anti_diag.

if __name__ == "__main__":
    solution = FindWinnerOnTicTacToeGame()

    print("Expected Output: A")
    print(
        "Actual Output:", solution.tictactoe([[0, 0], [2, 0], [1, 1], [2, 1], [2, 2]])
    )

    print("Expected Output: B")
    print(
        "Actual Output:",
        solution.tictactoe([[0, 0], [1, 1], [0, 1], [0, 2], [1, 0], [2, 0]]),
    )

    print("Expected Output: Draw")
    print(
        "Actual Output:",
        solution.tictactoe(
            [[0, 0], [1, 1], [2, 0], [1, 0], [1, 2], [2, 1], [0, 1], [0, 2], [2, 2]]
        ),
    )

    print("Expected Output: Pending")
    print("Actual Output:", solution.tictactoe([[0, 0]]))
