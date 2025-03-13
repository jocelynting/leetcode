from collections import deque


class SlidingPuzzle:
    def slidingPuzzle(self, board: list[list[int]]) -> int:
        origin = "".join(str(r) for row in board for r in row)
        target = "123450"

        graph = {0: [1, 3], 1: [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}

        queue = deque([(origin, 0)])
        visited = set([origin])

        while queue:
            cur, moves = queue.popleft()
            if cur == target:
                return moves

            index = cur.index("0")
            for nei in graph[index]:
                change = list(cur)
                change[index], change[nei] = change[nei], change[index]
                change = "".join(change)
                if change not in visited:
                    visited.add(change)
                    queue.append((change, moves + 1))

        return -1


if __name__ == "__main__":
    solution = SlidingPuzzle()

    print("Expected Output: 1")
    print("Actual Output:", solution.slidingPuzzle([[1, 2, 3], [4, 0, 5]]))

    print("Expected Output: -1")
    print("Actual Output:", solution.slidingPuzzle([[1, 2, 3], [5, 4, 0]]))

    print("Expected Output: 5")
    print("Actual Output:", solution.slidingPuzzle([[4, 1, 2], [5, 0, 3]]))
