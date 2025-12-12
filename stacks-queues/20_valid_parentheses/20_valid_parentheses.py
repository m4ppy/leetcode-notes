"""
LeetCode 20. Valid Parentheses
Link: https://leetcode.com/problems/valid-parentheses/
Difficulty: Easy
Primary: Stack
Tags: [stack, string, bracket-matching]
Solved: 2025-11-12
"""

from typing import List

class Solution:
    
    # --- Approach 1: Brute Force ---
    # Time: O(n²), Space: O(n)
    def isValid_brute_force(self, s: str) -> bool:
        while '()' in s or '[]' in s or '{}' in s:
            s = s.replace('()', '')
            s = s.replace('[]', '')
            s = s.replace('{}', '')

        return s == ''



    # --- Approach 2: Stack ---
    # Time: O(n), Space: O(n)
    def isValid_stack(self, s: str) -> bool:
        parentheses = { ')':'(', ']':'[', '}':'{' }
        stack = []

        for c in s:
            if c in parentheses:
                if stack and parentheses[c] == stack[-1]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)

        return True if not stack else False


# --- Example Test ---
if __name__ == "__main__":
    s = "()[]{}"

    solution = Solution()
    print(solution.isValid_stack(s)) # True