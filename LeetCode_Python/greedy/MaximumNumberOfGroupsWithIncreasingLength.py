class MaximumNumberOfGroupsWithIncreasingLength:
    def maxIncreasingGroups(self, usageLimits: list[int]) -> int:
        usageLimits.sort()

        res = 0
        total = 0

        for l in usageLimits:
            total += l

            if total >= res + 1:
                res += 1
                total -= res

        return res


# Time Complexity: O(nlogn)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MaximumNumberOfGroupsWithIncreasingLength()

    print("Expected Output : 3")
    print("Actual Output : ", solution.maxIncreasingGroups([1, 2, 5]))

    print("Expected Output : 2")
    print("Actual Output : ", solution.maxIncreasingGroups([2, 1, 1]))

    print("Expected Output : 1")
    print("Actual Output : ", solution.maxIncreasingGroups([1, 1]))
