// Approach 1: Breath First Search
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
}

// Approach 2: Depth First Search
// Time complexity: O(n)
// Space complexity: O(h) worst case: O(n) best case: O(log n)

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Approach 3: Iterative DFS
// Time complexity: O(n)
// Space complexity: O(n)

public class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }
}
