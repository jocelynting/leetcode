class KClosestPointsToOrigin:
    def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
        # points.sort(key=lambda x: x[0]**2 + x[1]**2)
        # return points[:k]
        n = len(points)
        distances = [0] * n

        for i in range(n):
            distances[i] = points[i][0] ** 2 + points[i][1] ** 2

        distances.sort()
        target = distances[k - 1]

        res = []
        for i in range(n):
            if points[i][0] ** 2 + points[i][1] ** 2 <= target:
                res.append(points[i])

        return res


# Time Complexity: O(N log N), where N is the number of points
# Space Complexity: O(N), for the distances array

if __name__ == "__main__":
    solution = KClosestPointsToOrigin()

    points = [[1, 3], [-2, 2]]
    k = 1
    print("Expected Output: [[-2, 2]]")
    print("Actual Output:", solution.kClosest(points, k))

    points = [[3, 3], [5, -1], [-2, 4]]
    k = 2
    print("Expected Output: [[-2, 4], [3, 3]]")
    print("Actual Output:", solution.kClosest(points, k))
