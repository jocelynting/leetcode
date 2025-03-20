from math import sqrt


class MinimumTimeToRepairCars:
    def repairCars(self, ranks: list[int], cars: int) -> int:
        left = 1
        right = min(ranks) * cars * cars

        def canRepair(time: int) -> bool:
            total = 0
            for r in ranks:
                repaired = int(sqrt(time / r))
                total += repaired
                if total >= cars:
                    return True
            return False

        while left < right:
            mid = left + (right - left) // 2
            if canRepair(mid):
                right = mid
            else:
                left = mid + 1
        return left


# Time Complexity: O(n * log(m)), where n is the total number of mechanics and m is the minimum time to repair all cars
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MinimumTimeToRepairCars()

    print("Expected Output: 16")
    print("Actual Output:", solution.repairCars([4, 2, 3, 1], 10))

    print("Expected Output: 16")
    print("Actual Output:", solution.repairCars([5, 1, 8], 6))
