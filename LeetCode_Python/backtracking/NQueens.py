class NQueens:
    def solveNQueens(self, n: int) -> list[list[str]]:
        res = []
        board = [["."] * n for _ in range(n)]
        cols = set()
        diag1 = set()
        diag2 = set()

        def backtracking(row: int) -> None:
            if row == n:
                res.append(["".join(r) for r in board])
                return
            for col in range(n):
                if col in cols or (row - col) in diag1 or (row + col) in diag2:
                    continue
                board[row][col] = "Q"
                cols.add(col)
                diag1.add(row - col)
                diag2.add(row + col)
                backtracking(row + 1)
                board[row][col] = "."
                cols.remove(col)
                diag1.remove(row - col)
                diag2.remove(row + col)

        backtracking(0)
        return res


if __name__ == "__main__":
    solution = NQueens()

    print(
        "Expected Output : [['.Q..', '...Q', 'Q...', '..Q.'], ['..Q.', 'Q...', '...Q', '.Q..']]"
    )
    print("Actual Output : ", solution.solveNQueens(4))

    print("Expected Output : [['Q']]")
    print("Actual Output : ", solution.solveNQueens(1))
