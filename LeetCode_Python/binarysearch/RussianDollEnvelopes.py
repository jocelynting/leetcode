import bisect


class RussianDollEnvelopes:
    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        def lis(nums):
            lis = []
            for num in nums:
                index = bisect.bisect_left(lis, num)
                if index == len(lis):
                    lis.append(num)
                else:
                    lis[index] = num
            return len(lis)

        return lis([envelope[1] for envelope in envelopes])


# Time Complexity: O(nlogn), where n is the number of envelopes
# The sorting step takes O(n log n) and the LIS step takes O(n log n) due to binary search.
# Space Complexity: O(n), for the dp array used in the LIS function.

if __name__ == "__main__":
    solution = RussianDollEnvelopes()

    print("Expected Output: 3")
    print("Actual Output:", solution.maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))

    print("Expected Output: 5")
    print(
        "Actual Output:",
        solution.maxEnvelopes([[1, 1], [2, 2], [3, 3], [4, 4], [5, 5]]),
    )
