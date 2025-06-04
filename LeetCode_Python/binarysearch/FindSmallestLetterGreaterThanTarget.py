class FindSmallestLetterGreaterThanTarget:
    def nextGreatestLetter(self, letters: list[str], target: str) -> str:
        n = len(letters)
        left, right = 0, n

        while left < right:
            mid = (left + right) // 2
            if letters[mid] <= target:
                left = mid + 1
            else:
                right = mid

        return letters[left] if left != n else letters[0]


# Time Complexity: O(log n), where n is the number of letters.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = FindSmallestLetterGreaterThanTarget()

    print("Expected Output: c")
    print("Actual Output:", solution.nextGreatestLetter(["c", "f", "j"], "a"))

    print("Expected Output: f")
    print("Actual Output:", solution.nextGreatestLetter(["c", "f", "j"], "c"))

    print("Expected Output: x")
    print("Actual Output:", solution.nextGreatestLetter(["x", "x", "y"], "z"))
