from TreeNode import TreeNode
from collections import defaultdict
from collections import deque


class AllNodesDistanceK:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> list[int]:
        self.graph = defaultdict(list)
        self.buildGraph(root, None, self.graph)

        queue = deque([(target, 0)])
        visited = set([target])
        res = []

        while queue:
            node, distance = queue.popleft()
            if distance == k:
                res.append(node.val)
                continue
            for neighbor in self.graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, distance + 1))
        return res

    def distanceKByDFS(self, root: TreeNode, target: TreeNode, k: int) -> list[int]:
        self.graph = defaultdict(list)
        self.buildGraph(root, None, self.graph)

        visited = set([target])
        res = []

        def dfs(node: TreeNode, distance: int) -> None:
            if distance == k:
                res.append(node.val)
                return
            for nei in self.graph[node]:
                if nei not in visited:
                    visited.add(nei)
                    dfs(nei, distance + 1)

        dfs(target, 0)
        return res

    def buildGraph(self, node: TreeNode, parent: TreeNode, graph: defaultdict) -> None:
        if node and parent:
            graph[node].append(parent)
            graph[parent].append(node)
        if node.left:
            self.buildGraph(node.left, node, graph)
        if node.right:
            self.buildGraph(node.right, node, graph)


# Time Complexity: O(N)
# Space Complexity: O(N)

if __name__ == "__main__":
    solution = AllNodesDistanceK()

    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)

    target = root.left
    k = 2
    print("Expected Output: [1, 7, 4]")
    print("Actual Output:", solution.distanceK(root, target, k))
    print("Actual Output:", solution.distanceKByDFS(root, target, k))
