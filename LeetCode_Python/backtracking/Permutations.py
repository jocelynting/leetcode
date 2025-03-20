class Permutations:
    def permute(self, nums: list[int]) -> list[list[int]]:
        res = []

        def backtrack(path: list[int]) -> None:
            if len(path) == len(nums):
                res.append(path[:])
                return

            for num in nums:
                if num not in path:
                    path.append(num)
                    backtrack(path)
                    path.pop()

        backtrack([])
        return res


# Time Complexity: O(n!)
# Space Complexity: O(n!)

"""
假设有 n 个不同的元素，要生成所有可能的排列。排列的定义是把所有元素按照某种顺序排成一列。
	•	第一个位置有 n 种选择，
	•	第二个位置有 n - 1 种选择，
	•	…
	•	最后一个位置只有 1 种选择。

所以，总的排列数为：

n * (n-1) * (n-2) * ... * 1 = n!

这意味着，当你生成所有排列时，输出的排列数量正好是 n!. 3 个元素的排列数为 3! = 6。
"""

if __name__ == "__main__":
    solution = Permutations()

    print(
        "Expected Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]"
    )
    print("Actual Output:", solution.permute([1, 2, 3]))

    print("Expected Output: [[0, 1], [1, 0]]")
    print("Actual Output:", solution.permute([0, 1]))
