import bisect


class FindTheLongestValidObstacleCourseAtEachPosition:
    def longestObstacleCourseAtEachPosition(self, obstacles: list[int]) -> list[int]:
        res = []
        lis = []

        for o in obstacles:
            index = bisect.bisect_right(lis, o)
            if index == len(lis):
                lis.append(o)
            else:
                lis[index] = o
            res.append(index + 1)

        return res


# Time Complexity: O(n log n), where n is the number of obstacles
# Space Complexity: O(n), for the lis array

if __name__ == "__main__":
    solution = FindTheLongestValidObstacleCourseAtEachPosition()

    print("Expected Output: [1, 2, 3, 3, 4, 4]")
    print(
        "Actual Output:",
        solution.longestObstacleCourseAtEachPosition([1, 2, 3, 2, 5, 4]),
    )

    print("Expected Output: [1, 2, 3, 4]")
    print("Actual Output:", solution.longestObstacleCourseAtEachPosition([1, 2, 3, 4]))

    print("Expected Output: [1, 2, 3, 2]")
    print("Actual Output:", solution.longestObstacleCourseAtEachPosition([1, 5, 5, 2]))
