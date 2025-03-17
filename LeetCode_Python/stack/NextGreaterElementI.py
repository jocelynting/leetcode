class NextGreaterElementI:
    def nextGreaterElement(self, nums1: list[int], nums2: list[int]) -> list[int]:
        next_greater = {}
        stack = []

        for num in nums2:
            while stack and stack[-1] < num:
                next_greater[stack.pop()] = num
            stack.append(num)

        while stack:
            next_greater[stack.pop()] = -1

        return [next_greater[num] for num in nums1]


if __name__ == "__main__":
    solution = NextGreaterElementI()

    print("Expected Output: [-1, 3, -1]")
    print("Actual Output:", solution.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]))

    print("Expected Output: [3, -1]")
    print("Actual Output:", solution.nextGreaterElement([2, 4], [1, 2, 3, 4]))

    print("Expected Output: [7, 7, 7, 7, 7]")
    print(
        "Actual Output:",
        solution.nextGreaterElement([1, 3, 5, 2, 4], [6, 5, 4, 3, 2, 1, 7]),
    )

    print("Expected Output: [-1, -1, -1, -1, -1]")
    print(
        "Actual Output:",
        solution.nextGreaterElement([1, 3, 5, 2, 4], [7, 6, 5, 4, 3, 2, 1]),
    )
