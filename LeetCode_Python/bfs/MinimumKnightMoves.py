from collections import deque


class MinimumKnightMoves:
    def minKnightMoves(self, x: int, y: int) -> int:
        directions = [
            (2, 1),
            (1, 2),
            (-1, 2),
            (-2, 1),
            (-2, -1),
            (-1, -2),
            (1, -2),
            (2, -1),
        ]
        x = abs(x)
        y = abs(y)

        queue = deque([(0, 0, 0)])
        visited = set([0, 0])

        while queue:
            cur_x, cur_y, steps = queue.popleft()
            if cur_x == x and cur_y == y:
                return steps
            for dir_x, dir_y in directions:
                next_x, next_y = cur_x + dir_x, cur_y + dir_y
                if (next_x, next_y) not in visited and next_x >= -2 and next_y >= -2:
                    queue.append((next_x, next_y, steps + 1))
                    visited.add((next_x, next_y))

        return -1


if __name__ == "__main__":
    solution = MinimumKnightMoves()

    print("Expected Output : 1")
    print("Actual Output : ", solution.minKnightMoves(2, 1))

    print("Expected Output : 4")
    print("Actual Output : ", solution.minKnightMoves(5, 5))
