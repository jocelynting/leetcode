import bisect


class RussianDollEnvelopes:
    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        def lis(nums):
            res = []
            for num in nums:
                index = bisect.bisect_left(res, num)
                if index == len(res):
                    res.append(num)
                else:
                    res[index] = num
            return len(res)

        return lis([envelope[1] for envelope in envelopes])


# Time Complexity: O(nlogn)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = RussianDollEnvelopes()

    print("Expected Output: 3")
    print("Actual Output:", solution.maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))

    print("Expected Output: 5")
    print(
        "Actual Output:",
        solution.maxEnvelopes([[1, 1], [2, 2], [3, 3], [4, 4], [5, 5]]),
    )
