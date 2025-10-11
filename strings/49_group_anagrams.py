# Approach 1: Sorting
# Time complexity: O(m ∗ n log n) m is number of strings and n is length of the logest string. sort string while traversing given list.
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

# Approach 2: Hash Table
# Time complexity: O(m ∗ n) m is number of strings and n is length of the logest string. count each string while traversing given list.
# Space complexity: O(m * n) for hash map that stores m keys that value is n.

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashMap = {}

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1

            key = tuple(count)
            if key in hashMap:
                hashMap[key].append(s)
            else:
                hashMap[key] = [s]

        return list(hashMap.values())
