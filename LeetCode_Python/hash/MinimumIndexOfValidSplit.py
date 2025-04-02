from collections import Counter


class MinimumIndexOfValidSplit:
    def minimumIndex(self, nums: list[int]) -> int:
        n = len(nums)

        freq = Counter(nums)
        num, count = freq.most_common(1)[0]

        left_count = 0

        for i in range(n):
            if nums[i] == num:
                left_count += 1
            right_count = count - left_count
            if left_count * 2 > i + 1 and right_count * 2 > n - (i + 1):
                return i

        return -1


# Time Complexity: O(nlog(n)) where n is the length of the input list
#                  The Counter.most_common method takes O(nlog(n)) time to count the frequency of elements
# Space Complexity: O(n) where n is the length of the input list


if __name__ == "__main__":
    solution = MinimumIndexOfValidSplit()

    print("Excepted Output: 2")
    print("Actual Output: ", solution.minimumIndex([1, 2, 2, 2]))

    print("Excepted Output: 4")
    print("Actual Output: ", solution.minimumIndex([2, 1, 3, 1, 1, 1, 7, 1, 2, 1]))

    print("Excepted Output: -1")
    print("Actual Output: ", solution.minimumIndex([3, 3, 3, 3, 7, 2, 2]))
