# Approach 1: Breath First Search
# Time complexity: O(n)
# Space complexity: O(n) for queue.

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: 
            return root

        queue = deque([root])
        while queue:
            node = queue.popleft()

            node.left, node.right = node.right, node.left
            
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        return root

# Approach 2: Depth First Search
# Time complexity: O(n)
# Space complexity: O(n) for call stack.

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        
        self.invertTree(root.left)
        self.invertTree(root.right)

        root.left, root.right = root.right, root.left

        return root

# Approach 3: Iterative DFS
# Time complexity: O(n)
# Space complexity: O(n) for stack.

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root

        stack = [root]

        while stack:
            node = stack.pop()
            node.left, node.right = node.right, node.left
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        
        return root
