from collections import defaultdict
from collections import deque


class EvaluateDivision:
    def calcEquation(
        self, equations: list[list[str]], values: list[float], queries: list[list[str]]
    ) -> list[float]:
        graph = defaultdict(dict)
        for (divident, divisor), value in zip(equations, values):
            graph[divident][divisor] = value
            graph[divisor][divident] = 1.0 / value

        def bfs(start: str, end: str) -> float:
            if start not in graph or end not in graph:
                return -1.0
            queue = deque([(start, 1.0)])
            visited = set([start])
            while queue:
                cur, value = queue.popleft()
                if cur == end:
                    return value
                for nei, nei_value in graph[cur].items():
                    if nei not in visited:
                        visited.add(nei)
                        queue.append((nei, value * nei_value))

        res = []
        for divident, divisor in queries:
            res.append(bfs(divident, divisor))

        return res

    def calEquationByDFS(
        self, equations: list[list[str]], values: list[float], queries: list[list[str]]
    ) -> list[float]:
        graph = defaultdict(dict)
        for (divident, divisor), value in zip(equations, values):
            graph[divident][divisor] = value
            graph[divisor][divident] = 1.0 / value

        def dfs(start: str, end: str, visited: set) -> float:
            if start == end:
                return 1.0

            visited.add(start)
            for nei, value in graph[start].items():
                if nei in visited:
                    continue
                res = dfs(nei, end, visited)
                if res != -1.0:
                    return value * res
            return -1.0

        res = []
        for divident, divisor in queries:
            if divident not in graph or divisor not in graph:
                res.append(-1.0)
            else:
                r = dfs(divident, divisor, set())
                res.append(r)

        return res


if __name__ == "__main__":
    solution = EvaluateDivision()

    equations = [["a", "b"], ["b", "c"]]
    values = [2.0, 3.0]
    queries = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
    print("Expected Output : [6.0, 0.5, -1.0, 1.0, -1.0]")
    print("Actual Output :", solution.calcEquation(equations, values, queries))
    print("Actual Output :", solution.calEquationByDFS(equations, values, queries))

    equations = [["a", "b"], ["b", "c"], ["bc", "cd"]]
    values = [1.5, 2.5, 5.0]
    queries = [["a", "c"], ["c", "b"], ["bc", "cd"], ["cd", "bc"]]
    print("Expected Output : [3.75, 0.4, 5.0, 0.2]")
    print("Actual Output :", solution.calcEquation(equations, values, queries))
    print("Actual Output :", solution.calEquationByDFS(equations, values, queries))
