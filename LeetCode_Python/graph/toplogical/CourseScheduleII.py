from collections import deque, defaultdict


class CourseScheduleII:
    def findOrder(self, numCourses: int, prerequisites: list[list[int]]) -> list[int]:
        graph = defaultdict(list)
        indegree = [0] * numCourses

        for pre in prerequisites:
            graph[pre[1]].append(pre[0])
            indegree[pre[0]] += 1

        queue = deque([i for i in range(numCourses) if indegree[i] == 0])

        res = []
        while queue:
            cur = queue.popleft()
            res.append(cur)
            for nei in graph[cur]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    queue.append(nei)

        return res if len(res) == numCourses else []


# Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites.
# Space Complexity: O(V + E), for storing the graph and indegree array.

if __name__ == "__main__":
    solution = CourseScheduleII()

    numCourses1 = 4
    prerequisites1 = [[1, 0], [2, 0], [3, 1], [3, 2]]
    print("Expected Output: [0,1,2,3] or [0,2,1,3]")
    print("Actual Output:", solution.findOrder(numCourses1, prerequisites1))

    numCourses2 = 2
    prerequisites2 = [[1, 0]]
    print("Expected Output: [0,1]")
    print("Actual Output:", solution.findOrder(numCourses2, prerequisites2))

    numCourses3 = 2
    prerequisites3 = [[1, 0], [0, 1]]
    print("Expected Output: []")
    print("Actual Output:", solution.findOrder(numCourses3, prerequisites3))
