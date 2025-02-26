class ValidParentheses:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}
        
        for ch in s:
            if ch in mapping:
                top_element = stack.pop() if stack else '#'
                if mapping[ch] != top_element:
                    return False
            else:
                stack.append(ch)
                
        return not stack

if __name__ == '__main__':
    solution = ValidParentheses()
    
    s1 = "()"
    print("Test Case 1: Input:", s1)
    print("Expected Output: True")
    print("Actual Output:", solution.isValid(s1))
    
    s2 = "()[]{}"
    print("Test Case 2: Input:", s2)
    print("Expected Output: True")
    print("Actual Output:", solution.isValid(s2))
    
    s3 = "(]"
    print("Test Case 3: Input:", s3)
    print("Expected Output: False")
    print("Actual Output:", solution.isValid(s3))
    
    s4 = "([)]"
    print("Test Case 4: Input:", s4)
    print("Expected Output: False")
    print("Actual Output:", solution.isValid(s4))
    
    s5 = "{[]}"
    print("Test Case 5: Input:", s5)
    print("Expected Output: True")
    print("Actual Output:", solution.isValid(s5))
