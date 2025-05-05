from TreeNode import TreeNode


class LongestZigZagPath:
    def longestZigZag(self, root: TreeNode) -> int:
        self.res = 0

        def dfs(node: TreeNode) -> tuple[int, int]:
            if not node:
                return -1, -1

            left, right = dfs(node.left), dfs(node.right)
            ll = left[0] + 1
            rl = right[0] + 1

            self.res = max(self.res, ll, rl)

            return ll, rl

        dfs(root)
        return self.res


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.

if __name__ == "__main__":
    solution = LongestZigZagPath()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)

    print("Expected Output: 2")
    print("Actual Output:", solution.longestZigZag(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    root.left.left.left = TreeNode(8)
    root.left.left.right = TreeNode(9)
    root.left.right.left = TreeNode(10)
    root.left.right.right = TreeNode(11)

    print("Expected Output: 3")
    print("Actual Output:", solution.longestZigZag(root))
