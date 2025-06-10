class PeakIndexInAMountainArray:
    def peakIndexInMountainArray(self, arr: list[int]) -> int:
        left, right = 0, len(arr) - 1

        while left < right:
            mid = (left + right) // 2
            if arr[mid] < arr[mid + 1]:
                left = mid + 1
            else:
                right = mid

        return left


# Time Complexity: O(log n), where n is the length of the input array.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = PeakIndexInAMountainArray()

    print("Expected Output : 1")
    print("Actual Output :", solution.peakIndexInMountainArray([0, 1, 0]))

    print("Expected Output : 1")
    print("Actual Output :", solution.peakIndexInMountainArray([0, 2, 1, 0]))

    print("Expected Output : 1")
    print("Actual Output :", solution.peakIndexInMountainArray([0, 10, 5, 2]))
