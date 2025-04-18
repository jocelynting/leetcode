from collections import deque


class Matrix01:
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        m, n = len(mat), len(mat[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        queue = deque()
        res = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j, 0))

        while queue:
            row, col, dist = queue.popleft()
            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < m and 0 <= c < n and mat[r][c] != 0:
                    mat[r][c] = 0
                    res[r][c] = dist + 1
                    queue.append((r, c, dist + 1))

        return res


# Time Complexity: O(m * n)
# Space Complexity: O(m * n)

if __name__ == "__main__":
    solution = Matrix01()

    print("Expected Output: [[0,0,0],[0,1,0],[0,0,0]]")
    print("Actual Output:", solution.updateMatrix([[0, 0, 0], [0, 1, 0], [0, 0, 0]]))

    print("Expected Output: [[0,0,0],[0,1,0],[1,2,1]]")
    print("Actual Output:", solution.updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1]]))
