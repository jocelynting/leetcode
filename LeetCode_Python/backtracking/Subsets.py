class Subsets:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        res = []
        n = len(nums)

        def backtracking(start: int, path: list[int]) -> None:
            res.append(path.copy())

            for i in range(start, n):
                path.append(nums[i])
                backtracking(i + 1, path)
                path.pop()

        backtracking(0, [])

        return res


# Time: O(N * 2^N)
# Space: O(N * 2^N)

""" Complexity Analysis
时间复杂度
1. 子集个数：
对于一个包含 n 个元素的数组，其子集总数为 2^n(每个元素可以选择或者不选择）。在回溯过程中，我们实际上生成了所有 2^n 个子集。
2. 生成每个子集的花费：
在生成过程中，每当我们将当前的 path 添加到结果列表时，我们使用了 path.copy()。在最坏情况下path 的长度可能为 O(n)(例如在生成完整子集时），因此每个子集复制的操作时间为 O(n)。
3. 总时间复杂度：
因此，总的时间复杂度为 O(2^n * n)。另外，遍历过程中每个子集构造过程中可能会有额外的递归和回溯操作，但总体上生成所有子集的数量主导时间复杂度为 O(n * 2^n)。

空间复杂度
空间复杂度需要考虑两部分：递归调用栈和存储结果所需的空间。
1. 递归调用栈：
回溯过程中，递归的最大深度为 n(即在构造一个包含 n 个元素的子集时）。因此递归栈空间为 O(n)。
2. 临时数据结构(path):
当前路径列表 path 最多会存储 n 个元素，因此需要 O(n) 的空间。
3. 输出空间：
输出结果包含 2^n 个子集，每个子集平均长度为 O(n)。因此输出空间为 O(n * 2^n)。
(如果不算输出空间，仅考虑辅助空间，则是 O(n)。）
"""

if __name__ == "__main__":
    solution = Subsets()

    print("Expected Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]")
    print("Actual Output:", solution.subsets([1, 2, 3]))

    print("Expected Output: [[],[0]]")
    print("Actual Output:", solution.subsets([0]))
