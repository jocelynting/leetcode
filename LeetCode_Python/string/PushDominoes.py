class PushDominoes:
    def pushDominoes(self, dominoes: str) -> str:
        n = len(dominoes)
        forces = [0] * n

        force = 0
        for i in range(n):
            if dominoes[i] == "R":
                force = n
            elif dominoes[i] == "L":
                force = 0
            else:
                force = max(force - 1, 0)
            forces[i] += force

        force = 0
        for i in range(n - 1, -1, -1):
            if dominoes[i] == "L":
                force = n
            elif dominoes[i] == "R":
                force = 0
            else:
                force = max(force - 1, 0)
            forces[i] -= force

        res = []
        for f in forces:
            if f > 0:
                res.append("R")
            elif f < 0:
                res.append("L")
            else:
                res.append(".")

        return "".join(res)


# Time complexity: O(n), where n is the length of the dominoes string.
# Space complexity: O(n), for the forces array.

if __name__ == "__main__":
    solution = PushDominoes()

    print("Expected Output: RR.L")
    print("Actual Output:", solution.pushDominoes("RR.L"))

    print("Expected Output: LL.RR.LLRRLL..")
    print("Actual Output:", solution.pushDominoes("LL.RR.LLRRLL.."))
