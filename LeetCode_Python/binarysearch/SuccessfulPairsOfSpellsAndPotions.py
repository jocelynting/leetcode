import bisect


class SuccessfulPairsOfSpellsAndPotions:
    def successfulPairs(
        self, spells: list[int], potions: list[int], success: int
    ) -> list[int]:
        potions.sort()

        def binarySearch(num: int) -> int:
            left, right = 0, len(potions)
            while left < right:
                mid = (left + right) // 2
                if potions[mid] * num < success:
                    left = mid + 1
                else:
                    right = mid
            return left

        res = []
        for s in spells:
            index = binarySearch(s)
            res.append(len(potions) - index)

        return res

    def successfulPairsByInnerBS(
        self, spells: list[int], potions: list[int], success: int
    ) -> list[int]:
        potions.sort()
        res = []

        for s in spells:
            min_potion = (success + s - 1) // s
            index = bisect.bisect_left(potions, min_potion)
            res.append(len(potions) - index)

        return res


# Time Complexity: O(n log n + m log n), where n is the length of potions and m is the length of spells
# Space Complexity: O(n), for the sorted potions list

if __name__ == "__main__":
    solution = SuccessfulPairsOfSpellsAndPotions()

    print("Expected Output: [4, 0, 3]")
    print("Actual Output:", solution.successfulPairs([5, 1, 3], [1, 2, 3, 4, 5], 7))
    print(
        "Actual Output:",
        solution.successfulPairsByInnerBS([5, 1, 3], [1, 2, 3, 4, 5], 7),
    )

    print("Expected Output: [2, 0, 2]")
    print("Actual Output:", solution.successfulPairs([3, 1, 2], [8, 5, 8], 16))
    print("Actual Output:", solution.successfulPairsByInnerBS([3, 1, 2], [8, 5, 8], 16))
