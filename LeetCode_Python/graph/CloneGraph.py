from Node import Node
from collections import deque

class CloneGraph:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        visited = {}

        def dfs(node):
            if node in visited:
                return visited[node]

            copy = Node(node.val)
            visited[node] = copy

            for neighbor in node.neighbors:
                copy.neighbors.append(dfs(neighbor))

            return copy

        return dfs(node)
    
    def cloneGraphByBFS(self, node: 'Node') -> 'Node':
        if not node:
            return None

        visited = {}
        queue = deque([node])
        visited[node] = Node(node.val)
        while queue:
            curr = queue.popleft()

            for neighbor in curr.neighbors:
                if neighbor not in visited:
                    visited[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)

                visited[curr].neighbors.append(visited[neighbor])
        return visited[node]
    
def print_graph(node: Node):
    visited = set()
    queue = deque([node])
    while queue:
        cur = queue.popleft()
        if cur.val in visited:
            continue
        visited.add(cur.val)
        print(f"Node {cur.val}: {[neighbor.val for neighbor in cur.neighbors]}")
        for neighbor in cur.neighbors:
            if neighbor.val not in visited:
                queue.append(neighbor)

if __name__ == "__main__":
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node1.neighbors = [node2, node4]
    node2.neighbors = [node1, node3]
    node3.neighbors = [node2, node4]
    node4.neighbors = [node1, node3]
    
    solution = CloneGraph()
    cloned_graph = solution.cloneGraph(node1)
    print_graph(cloned_graph)