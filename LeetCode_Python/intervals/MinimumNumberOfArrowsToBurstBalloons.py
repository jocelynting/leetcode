class MinimumNumberOfArrowsToBurstBalloons:
    def findMinArrowShots(self, points: list[list[int]]) -> int:
        points.sort(key=lambda x: x[1])

        res = 1
        end = points[0][1]

        for point in points[1:]:
            if point[0] > end:
                res += 1
                end = point[1]

        return res


# Time Complexity: O(nlogn) for sorting the points
# Space Complexity: O(1) for the variables used

if __name__ == "__main__":
    solution = MinimumNumberOfArrowsToBurstBalloons()

    print("Expected Output: 2")
    print(
        "Actual Output:",
        solution.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]),
    )

    print("Expected Output: 4")
    print(
        "Actual Output:", solution.findMinArrowShots([[1, 2], [3, 4], [5, 6], [7, 8]])
    )
