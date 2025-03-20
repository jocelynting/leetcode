class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None


class LowestCommonAncestorIII:
    def lowestCommonAncestor(self, p: Node, q: Node) -> Node:
        p1, q1 = p, q

        while p1 != q1:
            p1 = p1.parent if p1 else q
            q1 = q1.parent if q1 else p

        return p1


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = LowestCommonAncestorIII()

    root = Node(3)
    root.left = Node(5)
    root.left.parent = root
    root.right = Node(1)
    root.right.parent = root
    root.left.left = Node(6)
    root.left.left.parent = root.left
    root.left.right = Node(2)
    root.left.right.parent = root.left
    root.right.left = Node(0)
    root.right.left.parent = root.right
    root.right.right = Node(8)
    root.right.right.parent = root.right
    root.left.right.left = Node(7)
    root.left.right.left.parent = root.left.right

    p = root.left
    q = root.right

    print("Expected Output: 3")
    print("Actual Output:", solution.lowestCommonAncestor(p, q).val)
