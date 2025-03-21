class PermutationInString:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1, n2 = len(s1), len(s2)
        if n1 > n2:
            return False

        count1 = [0] * 26
        for c in s1:
            count1[ord(c) - ord("a")] += 1

        count2 = [0] * 26
        for c in s2[:n1]:
            count2[ord(c) - ord("a")] += 1

        if count1 == count2:
            return True

        for i in range(n1, n2):
            count2[ord(s2[i]) - ord("a")] += 1
            count2[ord(s2[i - n1]) - ord("a")] -= 1

            if count1 == count2:
                return True

        return False


# Time Complexity: O(n)
# Space Complexity: O(1) since the number of elements in the hashmap is at most 26

if __name__ == "__main__":
    solution = PermutationInString()

    print("Expected Output: True")
    print("Actual Output:", solution.checkInclusion("ab", "eidbaooo"))

    print("Expected Output: False")
    print("Actual Output:", solution.checkInclusion("ab", "eidboaoo"))
