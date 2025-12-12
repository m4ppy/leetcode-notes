"""
LeetCode 155. Min Stack
Link: https://leetcode.com/problems/min-stack/
Difficulty: Medium
Primary: Stack
Tags: [design, stack, data-structure, optimization]
Solved: 2025-11-12
"""

from typing import List

# --- Approach 1: One Stack ---
# Time: O(1), Space: O(n)
# each node in the stack having a minimum value 
class MinStack_OneStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        min_val = self.stack[-1][1] if self.stack else float('inf')
        if val < min_val: min_val = val
        self.stack.append((val, min_val))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
    
# --- Approach 2: Two Stack ---
# Time: O(1), Space: O(n)
# each node in the stack having a minimum value 
class MinStack_TwoStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        min_val = self.min_stack[-1] if self.min_stack else float('inf')
        min_val = min(min_val, val)
        self.stack.append(val)
        self.min_stack.append(min_val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


# --- Example Test ---
if __name__ == "__main__":
    minStack = MinStack_OneStack()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    assert minStack.getMin() == -3  # return -3
    minStack.pop()
    assert minStack.top() == 0      # return 0
    assert minStack.getMin() == -2  # return -2

    print("All tests passed.")