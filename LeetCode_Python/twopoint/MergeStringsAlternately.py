class MergeStringsAlternately:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = []
        i = j = 0
        n1, n2 = len(word1), len(word2)

        while i < n1 or j < n2:
            if i < n1:
                res.append(word1[i])
                i += 1
            if j < n2:
                res.append(word2[j])
                j += 1

        return "".join(res)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = MergeStringsAlternately()

    print("Expected Output: apbqcr")
    print("Actual Output: ", solution.mergeAlternately("abc", "pqr"))

    print("Expected Output: apbqcd")
    print("Actual Output: ", solution.mergeAlternately("ab", "pqcd"))
