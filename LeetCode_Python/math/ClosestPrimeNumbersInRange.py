class ClosestPrimeNumbersInRange:
    def closestPrimes(self, left: int, right: int) -> list[int]:
        n = right + 1

        is_prime = [True] * n
        is_prime[0] = is_prime[1] = False

        for i in range(2, int(n**0.5) + 1):
            if is_prime[i]:
                for j in range(i * i, n, i):
                    is_prime[j] = False

        if len(is_prime) < 2:
            return [-1, -1]

        prev = -1
        best_diff = float("inf")
        best_pair = [-1, -1]

        for num in range(left, right + 1):
            if is_prime[num]:
                if prev != -1:
                    diff = num - prev
                    if diff < best_diff:
                        best_diff = diff
                        best_pair = [prev, num]
                prev = num

        return best_pair


if __name__ == "__main__":
    solution = ClosestPrimeNumbersInRange()

    print("Expected Output: [11, 13]")
    print("Actual Output:", solution.closestPrimes(10, 19))

    print("Expected Output: [-1, -1]")
    print("Actual Output:", solution.closestPrimes(4, 6))
