import math


class MinimumSpeedToArriveOnTime:
    def minSpeedOnTime(self, dist: list[int], hour: float) -> int:
        def calculate(target: int) -> float:
            total = 0

            for i in range(len(dist) - 1):
                total += math.ceil(dist[i] / target)

            total += dist[-1] / target

            return total

        left, right = 1, 10**7
        res = -1

        while left <= right:
            mid = left + (right - left) // 2
            if calculate(mid) > hour:
                left = mid + 1
            else:
                res = mid
                right = mid - 1

        return res


# Time Complexity: O(n log m), where n is the length of dist and m is the maximum speed.
# Space Complexity: O(1), since we are using a constant amount of space.

if __name__ == "__main__":
    solution = MinimumSpeedToArriveOnTime()

    print("Expected Output: 1")
    print("Actual Output:", solution.minSpeedOnTime([1, 3, 2], 6))

    print("Expected Output: 3")
    print("Actual Output:", solution.minSpeedOnTime([1, 3, 2], 2.7))

    print("Expected Output: -1")
    print("Actual Output:", solution.minSpeedOnTime([1, 3, 2], 1.9))
