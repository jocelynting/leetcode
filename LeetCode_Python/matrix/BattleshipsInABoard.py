class BattleshipsInABoard:
    def countBattleships(self, board: list[list[str]]) -> int:
        m, n = len(board), len(board[0])
        res = 0

        for i in range(m):
            for j in range(n):
                if board[i][j] == "X":
                    if i > 0 and board[i - 1][j] == "X":
                        continue
                    if j > 0 and board[i][j - 1] == "X":
                        continue
                    res += 1

        return res


if __name__ == "__main__":
    solution = BattleshipsInABoard()

    board = [["X", ".", ".", "X"], [".", ".", ".", "X"], [".", ".", ".", "X"]]
    print("Expected Output : 2")
    print("Actual Output : ", solution.countBattleships(board))

    board = [["."]]
    print("Expected Output : 0")
    print("Actual Output : ", solution.countBattleships(board))
