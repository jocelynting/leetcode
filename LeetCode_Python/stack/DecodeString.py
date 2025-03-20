class DecodeString:
    def decodeString(self, s: str) -> str:
        stack = []
        res = ""
        num = 0

        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == "[":
                stack.append((res, num))
                res, num = "", 0
            elif c == "]":
                last_res, last_num = stack.pop()
                res = last_res + last_num * res
            else:
                res += c

        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = DecodeString()

    print("Expected Output: aaabcbc")
    print("Actual Output:", solution.decodeString("3[a]2[bc]"))

    print("Expected Output: accaccacc")
    print("Actual Output:", solution.decodeString("3[a2[c]]"))

    print("Expected Output: abcabccdcdcdef")
    print("Actual Output:", solution.decodeString("2[abc]3[cd]ef"))
