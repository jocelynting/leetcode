from UnionFind import UnionFind


class NumberOfProvinces:
    def findCircleNum(self, isConnected: list[list[int]]) -> int:
        n = len(isConnected)
        uf = UnionFind(n)
        res = n

        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] == 1 and uf.find(i) != uf.find(j):
                    uf.union(i, j)
                    res -= 1

        return res


# Time Complexity: O(n^2), where n is the number of cities.
# Space Complexity: O(n), for the union-find data structure.

if __name__ == "__main__":
    solution = NumberOfProvinces()

    isConnected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]

    print("Expected Output: 2")
    print("Actual Output:", solution.findCircleNum(isConnected))

    isConnected = [[1, 0, 0, 1], [0, 1, 0, 0], [0, 0, 1, 0], [1, 0, 0, 1]]
    print("Expected Output: 3")
    print("Actual Output:", solution.findCircleNum(isConnected))
