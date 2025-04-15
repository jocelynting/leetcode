class UnionFind:
    def __init__(self, size: int):
        self.parent = [i for i in range(size)]
        self.rank = [0] * size
        self.count = size

    def find(self, p: int) -> int:
        if self.parent[p] != p:
            self.parent[p] = self.find(self.parent[p])
        return self.parent[p]

    def union(self, p: int, q: int) -> None:
        root_p = self.find(p)
        root_q = self.find(q)

        if root_p != root_q:
            if self.rank[root_p] > self.rank[root_q]:
                self.parent[root_q] = root_p
            elif self.rank[root_p] < self.rank[root_q]:
                self.parent[root_p] = root_q
            else:
                self.parent[root_q] = root_p
                self.rank[root_p] += 1
            self.count -= 1
