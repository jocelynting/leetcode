from typing import Optional
from collections import defaultdict, deque


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class AmountOfTimeForBinaryTreeToBeInfected:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        graph = defaultdict(list)

        def buildGraph(node: TreeNode, parent: TreeNode):
            if not node:
                return
            if parent:
                graph[node.val].append(parent.val)
                graph[parent.val].append(node.val)
            buildGraph(node.left, node)
            buildGraph(node.right, node)

        buildGraph(root, None)
        queue = deque([start])
        visited = set([start])
        res = -1

        while queue:
            res += 1
            size = len(queue)
            for _ in range(size):
                node = queue.popleft()
                for nei in graph[node]:
                    if nei not in visited:
                        visited.add(nei)
                        queue.append(nei)

        return res


# Time Complexity: O(n), where n is the number of nodes in the tree as we are traversing each node once to build the graph and then again to perform BFS.
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = AmountOfTimeForBinaryTreeToBeInfected()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)

    start = 2

    print("Expected Output: 3")
    print("Actual Output:", solution.amountOfTime(root, start))
