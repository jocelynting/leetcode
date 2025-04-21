class CountAndSay:
    def countAndSay(self, n: int) -> str:
        res = "1"

        for _ in range(n - 1):
            i = 0
            cur = ""

            while i < len(res):
                count = 1

                while i + 1 < len(res) and res[i] == res[i + 1]:
                    count += 1
                    i += 1

                cur += str(count) + res[i]
                i += 1

            res = cur

        return res


# Time Complexity: O(n * m), where n is the input number and m is the length of the string generated in each iteration
# Space Complexity: O(m), where m is the length of the string generated in each iteration

if __name__ == "__main__":
    solution = CountAndSay()

    print("Expected Output: 1")
    print("Actual Output: ", solution.countAndSay(1))

    print("Expected Output: 11")
    print("Actual Output: ", solution.countAndSay(2))

    print("Expected Output: 21")
    print("Actual Output: ", solution.countAndSay(3))

    print("Expected Output: 1211")
    print("Actual Output: ", solution.countAndSay(4))

    print("Expected Output: 111221")
    print("Actual Output: ", solution.countAndSay(5))
