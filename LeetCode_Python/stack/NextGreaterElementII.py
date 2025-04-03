class NextGreaterElementII:
    def nextGreaterElement(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = [-1] * n
        stack = []

        for i in range(2 * n):
            index = i % n
            num = nums[index]

            while stack and nums[stack[-1]] < num:
                res[stack.pop()] = num

            if i < n:
                stack.append(index)

        return res


# Time Complexity: O(n)
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = NextGreaterElementII()

    print("Expected Output: [2, -1, 2]")
    print("Actual Output:", solution.nextGreaterElement([1, 2, 1]))

    print("Expected Output: [2, 3, 4, -1, 4]")
    print("Actual Output:", solution.nextGreaterElement([1, 2, 3, 4, 3]))
