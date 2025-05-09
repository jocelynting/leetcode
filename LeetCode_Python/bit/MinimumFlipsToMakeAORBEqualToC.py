class MinimumFlipsToMakeAORBEqualToC:
    def minFlips(self, a: int, b: int, c: int) -> int:
        res = 0

        for i in range(32):
            a_bit = (a >> i) & 1
            b_bit = (b >> i) & 1
            c_bit = (c >> i) & 1

            if c_bit == 0:
                res += a_bit + b_bit
            else:
                if a_bit == 0 and b_bit == 0:
                    res += 1

        return res


# Time Complexity: O(1), since we are iterating through a fixed number of bits (32 bits for integers).
# Space Complexity: O(1), since we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = MinimumFlipsToMakeAORBEqualToC()

    print("Expected Output: 3")
    print("Actual Output:", solution.minFlips(2, 6, 5))

    print("Expected Output: 1")
    print("Actual Output:", solution.minFlips(4, 2, 7))

    print("Expected Output: 0")
    print("Actual Output:", solution.minFlips(1, 2, 3))
