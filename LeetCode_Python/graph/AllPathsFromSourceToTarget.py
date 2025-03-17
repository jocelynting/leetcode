from collections import deque


class AllPathsFromSourceToTarget:
    def allPathsSourceTarget(self, graph: list[list[int]]) -> list[list[int]]:
        def dfs(node: int, path: list[int]) -> None:
            if node == len(graph) - 1:
                result.append(path)
                return
            for neighbor in graph[node]:
                dfs(neighbor, path + [neighbor])

        result = []
        dfs(0, [0])
        return result

    def allPathsSourceTargetByBFS(self, graph: list[list[int]]) -> list[list[int]]:
        result = []
        queue = deque([(0, [0])])
        while queue:
            node, path = queue.popleft()
            if node == len(graph) - 1:
                result.append(path)
            for neighbor in graph[node]:
                queue.append((neighbor, path + [neighbor]))
        return result


if __name__ == "__main__":
    solution = AllPathsFromSourceToTarget()

    print("Expected Output: [[0, 1, 3], [0, 2, 3]]")
    print("Actual Output:", solution.allPathsSourceTarget([[1, 2], [3], [3], []]))
    print("Actual Output:", solution.allPathsSourceTargetByBFS([[1, 2], [3], [3], []]))

    print("Expected Output: [[0, 1]]")
    print("Actual Output:", solution.allPathsSourceTarget([[1], []]))
    print("Actual Output:", solution.allPathsSourceTargetByBFS([[1], []]))
