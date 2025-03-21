from collections import deque


class SnakesAndLadders:
    def snakesAndLadders(self, board: list[list[int]]) -> int:
        n = len(board)

        def getPosition(num: int) -> tuple[int, int]:
            row = (num - 1) // n
            col = (num - 1) % n
            if row % 2 == 1:
                col = n - 1 - col
            return n - 1 - row, col

        visited = set([1])
        queue = deque([(1, 0)])

        while queue:
            num, moves = queue.popleft()
            if num == n * n:
                return moves
            for i in range(1, 7):
                next_num = num + i
                if next_num > n * n:
                    break
                row, col = getPosition(next_num)
                if board[row][col] != -1:
                    next_num = board[row][col]
                if next_num not in visited:
                    visited.add(next_num)
                    queue.append((next_num, moves + 1))

        return -1


# Time Complexity: O(n^2)
# Space Complexity: O(n^2)

if __name__ == "__main__":
    solution = SnakesAndLadders()

    board1 = [
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 35, -1, -1, 13, -1],
        [-1, -1, -1, -1, -1, -1],
        [-1, 15, -1, -1, -1, -1],
    ]
    print("Expected Output:", 4)
    print("Actual Output:", solution.snakesAndLadders(board1))

    board2 = [
        [-1, -1, 19, 10, -1],
        [2, -1, -1, 6, -1],
        [-1, 17, -1, 19, -1],
        [25, -1, 20, -1, -1],
        [-1, -1, -1, -1, 15],
    ]
    print("Expected Output:", 2)
    print("Actual Output:", solution.snakesAndLadders(board2))
