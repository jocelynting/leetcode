class BackspaceStringCompare:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def build(string):
            ans = []
            for c in string:
                if c != "#":
                    ans.append(c)
                elif ans:
                    ans.pop()
            return "".join(ans)

        return build(s) == build(t)


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
