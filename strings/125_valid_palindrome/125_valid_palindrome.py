# Approach 1: Reverse String
# Time complexity: O(n) optimize string.
# Space complexity: O(n) for optimized string.

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = ''.join(e for e in s if e.isalnum()).lower()
        return s==s[::-1]
