class StringCompression:
    def compress(self, chars: list[str]) -> int:
        n = len(chars)
        read = write = 0

        while read < n:
            char = chars[read]
            start = read

            while read < n and chars[read] == char:
                read += 1

            chars[write] = char
            write += 1

            count = read - start
            if count > 1:
                for digit in str(count):
                    chars[write] = digit
                    write += 1

        return write


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = StringCompression()

    print("Expected Output: 6")
    print("Actual Output: ", solution.compress(["a", "a", "b", "b", "c", "c", "c"]))

    print("Expected Output: 4")
    print(
        "Actual Output: ",
        solution.compress(
            ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]
        ),
    )

    print("Expected Output: 1")
    print("Actual Output: ", solution.compress(["a"]))
