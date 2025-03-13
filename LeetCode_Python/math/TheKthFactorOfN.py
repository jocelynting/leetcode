class TheKthFactorOfN:
    def kthFactor(self, n: int, k: int) -> int:
        if k == 1:
            return 1

        res = []

        for i in range(1, (int(n**0.5) + 1)):
            if n % i == 0:
                res.append(i)
                if i != n // i:
                    res.append(n // i)

        res.sort()

        return res[k - 1] if len(res) >= k else -1

    def kthFactor2(self, n: int, k: int) -> int:
        small_factors = []
        large_factors = []

        for i in range(1, int(n**0.5) + 1):
            if n % i == 0:
                small_factors.append(i)
                if i != n // i:
                    large_factors.append(n // i)

        factors = small_factors + large_factors[::-1]

        return factors[k - 1] if len(factors) >= k else -1


if __name__ == "__main__":
    solution = TheKthFactorOfN()

    print("Expected Output : 3")
    print("Actual Output : ", solution.kthFactor(12, 3))

    print("Expected Output : 7")
    print("Actual Output : ", solution.kthFactor(7, 2))

    print("Expected Output : -1")
    print("Actual Output : ", solution.kthFactor(4, 4))
