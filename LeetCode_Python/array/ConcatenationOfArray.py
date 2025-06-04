class ConcatenationOfArray:
    def getConcatenation(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = [0] * (2 * n)

        for i in range(n):
            res[i] = nums[i]
            res[i + n] = nums[i]

        return res


# Time Complexity: O(n), where n is the number of elements in the input list.
# Space Complexity: O(n), as we are creating a new list of size 2n.

if __name__ == "__main__":
    solution = ConcatenationOfArray()

    print("Expected Output: [1, 2, 1, 1, 2, 1]")
    print("Actual Output:", solution.getConcatenation([1, 2, 1]))

    print("Expected Output: [0, 0, 0, 0]")
    print("Actual Output:", solution.getConcatenation([0, 0]))
