class GCD:
    def __init__(self):
        pass

    def gcd(self, a: int, b: int) -> int:
        """
        Calculate the GCD of two numbers using the Euclidean algorithm.
        """
        while b:
            a, b = b, a % b
        return a
