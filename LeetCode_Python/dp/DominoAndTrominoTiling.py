class DominoAndTrominoTiling:
    def numTilings(self, n: int) -> int:
        mod = 10**9 + 7

        if n <= 2:
            return n

        f = [0] * (n + 1)
        p = [0] * (n + 1)

        f[1] = 1
        f[2] = 2
        p[2] = 1

        for i in range(3, n + 1):
            f[i] = (f[i - 1] + f[i - 2] * 2 + p[i - 1]) % mod
            p[i] = (f[i - 2] + p[i - 1]) % mod

        return f[n]


# Time Complexity: O(n), where n is the length of the dominoes string.
# Space Complexity: O(n), for the dp array.

if __name__ == "__main__":
    solution = DominoAndTrominoTiling()

    print("Expected Output: 5")
    print("Actual Output:", solution.numTilings(3))

    print("Expected Output: 1")
    print("Actual Output:", solution.numTilings(1))

    print("Expected Output: 11")
    print("Actual Output:", solution.numTilings(4))
