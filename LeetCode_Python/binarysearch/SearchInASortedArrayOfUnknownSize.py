class ArrayReader:
    def __init__(self, array: list[int]):
        self.array = array

    def get(self, index: int) -> int:
        return self.array[index] if index < len(self.array) else float("inf")


class SearchInASortedArrayOfUnknownSize:
    def search(self, reader: ArrayReader, target: int) -> int:
        left, right = 0, 1

        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = left + (right - left) // 2
            num = reader.get(mid)

            if num < target:
                left = mid + 1
            elif num > target:
                right = mid - 1
            else:
                return mid

        return -1


# Time Complexity: O(log n), where n is the number of elements in the array.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    reader = ArrayReader([1, 2, 3, 4, 5, 6, 7, 8, 9])
    solution = SearchInASortedArrayOfUnknownSize()

    target = 5
    print("Expected Output: 4")
    print("Actual Output:", solution.search(reader, target))

    target = 10
    print("Expected Output: -1")
    print("Actual Output:", solution.search(reader, target))
