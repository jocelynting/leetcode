class KthLexicographicalHappyStrings:
  def getHappyString(self, n: int, k: int) -> str:
        res = []

        def backtracking(cur: str) -> None:
            if len(cur) == n:
                res.append(cur)
                return
            for c in "abc":
                if not cur or cur[-1] != c:
                    backtracking(cur + c)
        
        backtracking("")

        return res[k - 1] if k <= len(res) else ""

if __name__ == '__main__':
    solution = KthLexicographicalHappyStrings()
    
    n1, k1 = 3, 9
    # Expected output: "cab"
    print(solution.getHappyString(n1, k1))
    
    n2, k2 = 1, 3
    # Expected output: "c"
    print(solution.getHappyString(n2, k2))
    
    n3, k3 = 1, 4
    # Expected output: ""
    print(solution.getHappyString(n3, k3))
    
    # Expected output:  "bc"
    n4, k4 = 2, 4
    print(solution.getHappyString(n4, k4))