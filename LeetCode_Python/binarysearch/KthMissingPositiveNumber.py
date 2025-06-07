class KthMissingPositiveNumber:
    def findKthPositive(self, arr: list[int], k: int) -> int:
        left, right = 0, len(arr)

        while left < right:
            mid = left + (right - left) // 2
            count = arr[mid] - (mid + 1)

            if count < k:
                left = mid + 1
            else:
                right = mid

        return left + k


# Time Complexity: O(log n), where n is the length of the array.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = KthMissingPositiveNumber()

    print("Expected Output: 9")
    print("Actual Output:", solution.findKthPositive([2, 3, 4, 7, 11], 5))

    print("Expected Output: 6")
    print("Actual Output:", solution.findKthPositive([1, 2, 3, 4], 2))

    print("Expected Output: 9")
    print("Actual Output:", solution.findKthPositive([1, 2, 3, 4], 5))
