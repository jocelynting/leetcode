from typing import Optional
from TreeNode import TreeNode


class UniqueBinarySearchTreesII:
    def generateTrees(self, n: int) -> list[Optional[TreeNode]]:
        def build(start: int, end: int) -> list[Optional[TreeNode]]:
            if start > end:
                return [None]

            res = []
            for i in range(start, end + 1):
                left = build(start, i - 1)
                right = build(i + 1, end)
                for l in left:
                    for r in right:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.append(root)

            return res

        return build(1, n) if n > 0 else []


# Time Complexity: O(4^n / ⎷n), where n is the number of nodes
# Space Complexity: O(n * c(n)), where c(n) is the number of unique BSTs for n nodes

if __name__ == "__main__":
    solution = UniqueBinarySearchTreesII()

    print("Expected Output: 5")
    print("Actual Output:", len(solution.generateTrees(3)))

    print("Expected Output: 14")
    print("Actual Output:", len(solution.generateTrees(4)))

    print("Expected Output: 1")
    print("Actual Output:", len(solution.generateTrees(1)))
