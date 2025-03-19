class CapacityToShipPackagesWithinDDays:
    def shipWithinDays(self, weights: list[int], days: int) -> int:
        left, right = max(weights), sum(weights)

        def calculateDays(target: int) -> int:
            days = 0
            total = 0
            for w in weights:
                total += w
                if total > target:
                    days += 1
                    total = w
            if total > 0:
                days += 1
            return days

        while left < right:
            mid = left + (right - left) // 2
            if calculateDays(mid) > days:
                left = mid + 1
            else:
                right = mid

        return left


if __name__ == "__main__":
    solution = CapacityToShipPackagesWithinDDays()

    print("Expected Output : 15")
    print(
        "Actual Output : ", solution.shipWithinDays([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5)
    )

    print("Expected Output : 6")
    print("Actual Output : ", solution.shipWithinDays([3, 2, 2, 4, 1, 4], 3))

    print("Expected Output : 3")
    print("Actual Output : ", solution.shipWithinDays([1, 2, 3, 1, 1], 4))
