class ValidNumber:
    def isNumber(self, s: str) -> bool:
        s = s.strip()
        if not s:
            return False

        is_digit = False
        has_dot = False
        has_e = False

        for i, char in enumerate(s):
            if char.isdigit():
                is_digit = True
            elif char == ".":
                if has_dot or has_e:
                    return False
                has_dot = True
            elif char in ("e", "E"):
                if has_e or not is_digit:
                    return False
                has_e = True
                is_digit = False
            elif char in ("+", "-"):
                if i > 0 and s[i - 1] not in ("e", "E"):
                    return False
            else:
                return False

        return is_digit

    def isNumberByDFA(self, s: str) -> bool:
        states = {
            0: {"blank": 0, "sign": 1, "digit": 2, ".": 3},
            1: {"digit": 2, ".": 3},
            2: {"digit": 2, ".": 4, "e": 5, "blank": 8},
            3: {"digit": 4},
            4: {"digit": 4, "e": 5, "blank": 8},
            5: {"sign": 6, "digit": 7},
            6: {"digit": 7},
            7: {"digit": 7, "blank": 8},
            8: {"blank": 8},
        }

        state = 0
        accepted = {2, 4, 7, 8}

        for char in s:
            if char.isspace():
                t = "blank"
            elif char in "+-":
                t = "sign"
            elif char.isdigit():
                t = "digit"
            elif char in "eE":
                t = "e"
            elif char == ".":
                t = "."
            else:
                return False

            if t not in states[state]:
                return False

            state = states[state][t]

        return state in accepted


# Time Complexity: O(n), where n is the length of the string s.
# Space Complexity: O(1), no extra space is used.

if __name__ == "__main__":
    solution = ValidNumber()

    print("Expected Output: True")
    print("Actual Output:", solution.isNumber("0"))
    print("Actual Output:", solution.isNumberByDFA("0"))

    print("Expected Output: True")
    print("Actual Output:", solution.isNumber("0.1"))
    print("Actual Output:", solution.isNumberByDFA("0.1"))

    print("Expected Output: False")
    print("Actual Output:", solution.isNumber("abc"))
    print("Actual Output:", solution.isNumberByDFA("abc"))

    print("Expected Output: False")
    print("Actual Output:", solution.isNumber("1 a"))
    print("Actual Output:", solution.isNumberByDFA("1 a"))

    print("Expected Output: False")
    print("Actual Output:", solution.isNumber("."))
    print("Actual Output:", solution.isNumberByDFA("."))
