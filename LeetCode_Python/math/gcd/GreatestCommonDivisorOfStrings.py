from math import gcd


class GreatestCommonDivisorOfStrings:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""

        max_length = gcd(len(str1), len(str2))
        return str1[:max_length]


# Time Complexity: O(n), where n is the length of the longer string, gcd is O(log(min(a, b))) and string concatenation is O(n)
# Space Complexity: O(1), we are not using any extra space that grows with the input size

if __name__ == "__main__":
    solution = GreatestCommonDivisorOfStrings()

    print("Expected Output : ABC")
    print("Actual Output : ", solution.gcdOfStrings("ABCABC", "ABC"))

    print("Expected Output : AB")
    print("Actual Output : ", solution.gcdOfStrings("ABABAB", "ABAB"))

    print("Expected Output : ")
    print("Actual Output : ", solution.gcdOfStrings("LEET", "CODE"))
