from collections import deque


class NumberOfProvinces:
    def findCircleNum(self, isConnected: list[list[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n
        res = 0

        def dfs(city: int):
            for i in range(n):
                if isConnected[city][i] == 1 and not visited[i]:
                    visited[i] = True
                    dfs(i)

        for i in range(n):
            if not visited[i]:
                dfs(i)
                res += 1

        return res

    def findCircleNumByBFS(self, isConnected: list[list[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n
        res = 0

        def bfs(city: int):
            queue = deque([city])
            visited[city] = True
            while queue:
                current_city = queue.popleft()
                for i in range(n):
                    if isConnected[current_city][i] == 1 and not visited[i]:
                        visited[i] = True
                        queue.append(i)

        for i in range(n):
            if not visited[i]:
                bfs(i)
                res += 1

        return res


# Time Complexity: O(n^2), where n is the number of cities, since we need to check each city and its connections
# Space Complexity: O(n), where n is the number of cities, since we need to keep track of visited cities

if __name__ == "__main__":
    solution = NumberOfProvinces()

    isConnected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]

    print("Expected Output: 2")
    print("Actual Output:", solution.findCircleNum(isConnected))
    print("Actual Output:", solution.findCircleNumByBFS(isConnected))

    isConnected = [[1, 0, 0, 1], [0, 1, 0, 0], [0, 0, 1, 0], [1, 0, 0, 1]]
    print("Expected Output: 3")
    print("Actual Output:", solution.findCircleNum(isConnected))
    print("Actual Output:", solution.findCircleNumByBFS(isConnected))
