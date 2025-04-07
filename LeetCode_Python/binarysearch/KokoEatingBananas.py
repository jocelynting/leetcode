import math


class KokoEatingBananas:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        left, right = 1, max(piles)

        def calculateHours(target: int) -> int:
            hours = 0
            for pile in piles:
                hours += math.ceil(pile / target)
            return hours

        while left < right:
            mid = (left + right) // 2
            hours = calculateHours(mid)

            if hours <= h:
                right = mid
            else:
                left = mid + 1

        return left


# Time Complexity: O(n * log(max(piles)))
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = KokoEatingBananas()

    print("Expected Output: 4")
    print("Actual Output:", solution.minEatingSpeed([3, 6, 7, 11], 8))

    print("Expected Output: 30")
    print("Actual Output:", solution.minEatingSpeed([30, 11, 23, 4, 20], 5))
