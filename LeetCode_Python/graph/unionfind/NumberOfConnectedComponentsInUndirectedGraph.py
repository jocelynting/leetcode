from UnionFind import UnionFind


class NumberOfConnectedComponentsInUndirectedGraph:
    def countComponents(self, n: int, edges: list[list[int]]) -> int:
        uf = UnionFind(n)
        for u, v in edges:
            uf.union(u, v)
        return uf.count


# Time Complexity: O(E * α(N)), where E is the number of edges and α(N) is the inverse Ackermann function
# Space Complexity: O(N), for the parent and rank arrays in the UnionFind class

if __name__ == "__main__":
    solution = NumberOfConnectedComponentsInUndirectedGraph()

    n = 5
    edges = [[0, 1], [1, 2], [3, 4]]
    print("Expected Output: 2")
    print("Actual Output:", solution.countComponents(n, edges))

    n = 5
    edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
    print("Expected Output: 1")
    print("Actual Output:", solution.countComponents(n, edges))
