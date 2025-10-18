# Approach 1: Breath First Search
# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth = 0

        if not root:
            return depth

        queue = deque([root])
        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            depth += 1

        return depth

# Approach 2: Depth First Search
# Time complexity: O(n)
# Space complexity: O(h) worst case: O(n) best case: O(log n)

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

# Approach 3: Iterative DFS
# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth = 0

        if not root:
            return depth

        stack = [(root, 1)]
        while stack:
            for _ in range(len(stack)):
                node, cur = stack.pop()
                depth = max(cur, depth)
                if node.left:
                    stack.append((node.left, 1 + cur))
                if node.right:
                    stack.append((node.right, 1 + cur))

        return depth
