# Approach 1: Sorting
# Time complexity: O(m ∗ n log n) m is number of strings and n is length of the logest string. sorting that string and traverse strs once.
# Space complexity: O(m * n) for hash map.

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = {}

        for s in strs:
            key = str(sorted(s))
            
            if key in res:
                res[key].append(s)
            else:
                res[key] = [s]

        return list(res.values())
