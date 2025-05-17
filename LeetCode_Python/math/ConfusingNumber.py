class ConfusingNumber:
    def confusingNumber(self, n: int) -> bool:
        dic = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        num = 0
        original = n

        while original > 0:
            digit = original % 10
            if digit not in dic:
                return False

            num = num * 10 + dic[digit]
            original //= 10

        return num != n


# Time Complexity : O(L), since the input number n has L digits,
# it requires O(L) floor divisions and modulo operations,
# and a floor division/modulo operation of n to 10 takes constant time.
# Space Complexity : O(L), we create a new integer which will have the same number of digits as n.
# In memory, the number of bits needed to store this integer is logarithmic with n.
# Since we defined L=log 10n, the space complexity is O(L), because all logarithms are related by a constant factor.


if __name__ == "__main__":
    solution = ConfusingNumber()

    print("Expected Output : True")
    print("Actual Output : ", solution.confusingNumber(6))

    print("Expected Output : False")
    print("Actual Output : ", solution.confusingNumber(1))

    print("Expected Output : True")
    print("Actual Output : ", solution.confusingNumber(689))
