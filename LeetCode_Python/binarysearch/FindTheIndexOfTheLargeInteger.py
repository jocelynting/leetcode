class ArrayReader:
    def __init__(self, nums: list[int]):
        self.nums = nums

    def compareSub(self, l: int, r: int, x: int, y: int) -> int:
        sum1 = sum(self.nums[l : r + 1])
        sum2 = sum(self.nums[x : y + 1])
        if sum1 < sum2:
            return -1
        elif sum1 > sum2:
            return 1
        else:
            return 0

    def length(self) -> int:
        return len(self.nums)


class FindTheIndexOfTheLargeInteger:
    def getIndex(self, reader: ArrayReader) -> int:
        left, right = 0, reader.length() - 1

        while left < right:
            n = (right - left + 1) // 2
            ms1, me1 = left, left + n - 1
            ms2, me2 = right - n + 1, right

            res = reader.compareSub(ms1, me1, ms2, me2)
            if res == 1:
                right = me1
            elif res == -1:
                left = ms2
            else:
                left = me1 + 1
                right = ms2 - 1

        return left


# Time Complexity: O(log n), where n is the length of the array.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":

    solution = FindTheIndexOfTheLargeInteger()

    reader = ArrayReader([7, 7, 7, 7, 10, 7, 7, 7])
    print("Expected Output: 4")
    print("Actual Output:", solution.getIndex(reader))

    reader = ArrayReader([6, 6, 12])
    print("Expected Output: 2")
    print("Actual Output:", solution.getIndex(reader))
