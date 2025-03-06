class WordSearch:
    def exist(self, board: list[list[str]], word: str) -> bool:
        m, n = len(board), len(board[0])

        def backtracking(index: int, row: int, col: int) -> bool:
            if index == len(word):
                return True

            if (
                row < 0
                or row >= m
                or col < 0
                or col >= n
                or board[row][col] != word[index]
            ):
                return False

            board[row][col] = "#"

            found = (
                backtracking(index + 1, row - 1, col)
                or backtracking(index + 1, row + 1, col)
                or backtracking(index + 1, row, col - 1)
                or backtracking(index + 1, row, col + 1)
            )

            board[row][col] = word[index]

            return found

        for i in range(m):
            for j in range(n):
                if backtracking(0, i, j):
                    return True

        return False


if __name__ == "__main__":
    solution = WordSearch()

    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    print("Expected Output : True")
    print("Actual Output : ", solution.exist(board, word))

    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "SEE"
    print("Expected Output : True")
    print("Actual Output : ", solution.exist(board, word))

    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCB"
    print("Expected Output : False")
    print("Actual Output : ", solution.exist(board, word))
