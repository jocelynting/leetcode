class TicTacToe:
    def __init__(self, n: int):
        self.n = n
        self.rows = [0] * n
        self.cols = [0] * n
        self.diag = 0
        self.anti_diag = 0

    def move(self, row: int, col: int, player: int) -> int:
        score = 1 if player == 1 else -1

        self.rows[row] += score
        self.cols[col] += score

        if row == col:
            self.diag += score
        if row + col == self.n - 1:
            self.anti_diag += score

        if (
            abs(self.rows[row]) == self.n
            or abs(self.cols[col]) == self.n
            or abs(self.diag) == self.n
            or abs(self.anti_diag) == self.n
        ):
            return player
        return 0


if __name__ == "__main__":
    solution = TicTacToe(3)

    print("Expected Output : 0")
    print("Actual Output : ", solution.move(0, 0, 1))
    print("Expected Output : 0")
    print("Actual Output : ", solution.move(0, 2, 2))
    print("Expected Output : 0")
    print("Actual Output : ", solution.move(2, 2, 1))
    print("Expected Output : 0")
    print("Actual Output : ", solution.move(1, 1, 2))
    print("Expected Output : 0")
    print("Actual Output : ", solution.move(2, 0, 1))
    print("Expected Output : 0")
    print("Actual Output : ", solution.move(1, 0, 2))
    print("Expected Output : 1")
    print("Actual Output : ", solution.move(2, 1, 1))
