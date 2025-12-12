"""
LeetCode 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/
Difficulty: Easy
Primary: hashmap
Tags: [string, hashmap, sorting]
Solved: 2025-11-11
"""

from typing import List

class Solution:
    
    # --- Approach 1: Sorting ---
    # Time: O(n²), Space: O(1)
    def isAnagram_sorting(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        return sorted(s) == sorted(t)


    # --- Approach 2: Hash Map ---
    # Time: O(n), Space: O(1)
    def isAnagram_hash_map(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)

        return countS == countT
    

    # --- Approach 3: Hash Table (Array) ---
    # Time: O(n), Space: O(1)
    def isAnagram_hash_table(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1

        for c in count:
            if c != 0:
                return False
            
        return True


# --- Example Test ---
if __name__ == "__main__":
    s = "anagram"
    t = "nagaram"
    solution = Solution()
    print(solution.isAnagram_hash_table(s, t)) # True