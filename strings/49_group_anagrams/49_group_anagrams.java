// Approach 1: Sorting
// Time complexity: O(m ∗ n log n) m is number of strings and n is length of the logest string. sort string while traversing given list.
// Space complexity: O(m * n) for hash map.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

// Approach 2: Hash Table
// Time complexity: O(m ∗ n) m is number of strings and n is length of the logest string. count each string while traversing given list.
// Space complexity: O(m * n) for hash map that stores m keys that value is n.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
