class FindKClosestElements:
    def findClosestElements(self, arr, k, x):
        n = len(arr)
        left, right = 0, n - k

        while left < right:
            mid = left + (right - left) // 2

            if arr[mid + k] - x < x - arr[mid]:
                left = mid + 1
            else:
                right = mid

        return arr[left : left + k]


# Time Complexity: O(log(n-k)), where n is the length of the array, and k is the number of closest elements to find.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = FindKClosestElements()

    print("Expected Output: [1, 2, 3, 4]")
    print("Actual Output:", solution.findClosestElements([1, 2, 3, 4, 5], 4, 3))

    print("Expected Output: [1, 1, 2, 3]")
    print("Actual Output:", solution.findClosestElements([1, 1, 2, 3, 4, 5], 4, -1))
