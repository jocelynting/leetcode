class CountGoodTriplets:
    def countGoodTriplets(self, arr: list[int], a: int, b: int, c: int) -> int:
        n = len(arr)
        res = 0
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    if (
                        abs(arr[i] - arr[j]) <= a
                        and abs(arr[j] - arr[k]) <= b
                        and abs(arr[i] - arr[k]) <= c
                    ):
                        res += 1
        return res


# Time Complexity: O(n^3)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = CountGoodTriplets()

    arr = [3, 0, 1, 1, 9, 7]
    a = 7
    b = 2
    c = 3
    print("Expected Output:", 4)
    print("Actual Output:", solution.countGoodTriplets(arr, a, b, c))

    arr = [1, 1, 2, 2, 3]
    a = 0
    b = 0
    c = 1
    print("Expected Output:", 0)
    print("Actual Output:", solution.countGoodTriplets(arr, a, b, c))
