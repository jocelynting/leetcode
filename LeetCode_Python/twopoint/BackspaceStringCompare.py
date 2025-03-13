class BackspaceStringCompare:
    def backspaceCompare(self, s: str, t: str) -> bool:
        i, j = len(s) - 1, len(t) - 1

        while i >= 0 or j >= 0:
            skip_s = 0
            while i >= 0:
                if s[i] == "#":
                    skip_s += 1
                    i -= 1
                elif skip_s > 0:
                    skip_s -= 1
                    i -= 1
                else:
                    break

            skip_t = 0
            while j >= 0:
                if t[j] == "#":
                    skip_t += 1
                    j -= 1
                elif skip_t > 0:
                    skip_t -= 1
                    j -= 1
                else:
                    break

            if i >= 0 and j >= 0:
                if s[i] != t[j]:
                    return False
            elif i >= 0 or j >= 0:
                return False

            i -= 1
            j -= 1

        return True


if __name__ == "__main__":
    solution = BackspaceStringCompare()

    s = "ab#c"
    t = "ad#c"
    print("Expected Output : True")
    print("Actual Output : " + str(solution.backspaceCompare(s, t)))

    s = "ab##"
    t = "c#d#"
    print("Expected Output : True")
    print("Actual Output : " + str(solution.backspaceCompare(s, t)))

    s = "a##c"
    t = "#a#c"
    print("Expected Output : True")
    print("Actual Output : " + str(solution.backspaceCompare(s, t)))

    s = "a#c"
    t = "b"
    print("Expected Output : False")
    print("Actual Output : " + str(solution.backspaceCompare(s, t)))
