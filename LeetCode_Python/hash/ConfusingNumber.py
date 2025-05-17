class ConfusingNumber:
    def confusingNumber(self, n: int) -> bool:
        dic = {"0": "0", "1": "1", "6": "9", "8": "8", "9": "6"}
        rotate = []

        for char in str(n):
            if char not in dic:
                return False

            rotate.append(dic[char])

        rotate.reverse()
        num = int("".join(rotate))

        return num != n


# Time Complexity : O(L), since the input number n has L digits,
# it requires O(L) time to iterate over and convert each digit of n, then O(L) again to reverse the result.
# Note that string is immutable in python, so we add each digit to a list,
# and convert the final list of digits to the string, which is a process that costs O(L).
# Space Complexity : O(L), since we are using a list to store the digits of the rotated number.


if __name__ == "__main__":
    solution = ConfusingNumber()

    print("Expected Output : True")
    print("Actual Output : ", solution.confusingNumber(6))

    print("Expected Output : False")
    print("Actual Output : ", solution.confusingNumber(1))

    print("Expected Output : True")
    print("Actual Output : ", solution.confusingNumber(689))
