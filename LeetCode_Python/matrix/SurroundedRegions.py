from collections import deque


class SurroundedRegions:
    def solve(self, board: list[list[str]]) -> None:
        m, n = len(board), len(board[0])

        def dfs(row: int, col: int) -> None:
            if row < 0 or row >= m or col < 0 or col >= n or board[row][col] != "O":
                return
            board[row][col] = "#"
            dfs(row - 1, col)
            dfs(row + 1, col)
            dfs(row, col - 1)
            dfs(row, col + 1)

        for r in range(m):
            dfs(r, 0)
            dfs(r, n - 1)

        for c in range(n):
            dfs(0, c)
            dfs(m - 1, c)

        for r in range(m):
            for c in range(n):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "#":
                    board[r][c] = "O"

    def solveByBFS(self, board: list[list[str]]) -> None:
        m, n = len(board), len(board[0])
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def bfs(row: int, col: int) -> None:
            if board[row][col] != "O":
                return
            board[row][col] = "#"

            queue = deque([(row, col)])
            while queue:
                r, c = queue.popleft()
                for dr, dc in directions:
                    new_r, new_c = r + dr, c + dc
                    if 0 <= new_r < m and 0 <= new_c < n and board[new_r][new_c] == "O":
                        board[new_r][new_c] = "#"
                        queue.append((new_r, new_c))

        for r in range(m):
            bfs(r, 0)
            bfs(r, n - 1)
        for c in range(n):
            bfs(0, c)
            bfs(m - 1, c)

        for r in range(m):
            for c in range(n):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "#":
                    board[r][c] = "O"


if __name__ == "__main__":
    solution = SurroundedRegions()

    board1 = [
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
    ]
    solution.solve(board1)
    print(
        "Expected Output: [['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'O', 'X', 'X']]"
    )
    print("Actual Output:", board1)

    board1 = [
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
    ]
    solution.solveByBFS(board1)
    print("Actual Output:", board1)

    board2 = [["X"]]
    solution.solve(board2)
    print("Expected Output: [['X']]")
    print("Actual Output:", board2)

    board2 = [["X"]]
    solution.solveByBFS(board2)
    print("Actual Output:", board2)

    board3 = [
        ["O", "O", "O"],
        ["O", "O", "O"],
        ["O", "O", "O"],
    ]
    solution.solve(board3)
    print("Expected Output: [['O', 'O', 'O'], ['O', 'O', 'O'], ['O', 'O', 'O']]")
    print("Actual Output:", board3)

    board3 = [
        ["O", "O", "O"],
        ["O", "O", "O"],
        ["O", "O", "O"],
    ]
    solution.solveByBFS(board3)
    print("Actual Output:", board3)
