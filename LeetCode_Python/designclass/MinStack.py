class MinStack:
    def __init__(self):
        self.min_stack = []
        self.stack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]

class MinStackByTuple:
    def __init__(self):
        self.stack = []
        
    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val, val))
        else:
            self.stack.append((val, min(val, self.stack[-1][1])))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]

if __name__ == '__main__':
    minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    print("getMin() -> Expected: -3, Actual:", minStack.getMin())  
    minStack.pop()
    print("top() -> Expected: 0, Actual:", minStack.top())         
    print("getMin() -> Expected: -2, Actual:", minStack.getMin())   

    minStack = MinStackByTuple()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    print("getMin() -> Expected: -3, Actual:", minStack.getMin())
    minStack.pop()
    print("top() -> Expected: 0, Actual:", minStack.top())
    print("getMin() -> Expected: -2, Actual:", minStack.getMin()) 
