/*
LeetCode 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/
Difficulty: Easy
Primary: hashmap
Tags: [string, hashmap, sorting]
Solved: 2025-11-11
*/

import java.util.*;

class Solution {

    // --- Approach 1: Sorting ---
    // Time: O(n²), Space: O(1)
    public boolean isAnagram_sorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }


    // --- Approach 2: Hash Map ---
    // Time: O(n), Space: O(1)
    public boolean isAnagram_hashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return countS.equals(countT);
    }


    // --- Approach 3: Hash Table (Array) ---
    // Time: O(n), Space: O(1)
    public boolean isAnagram_hashTable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";

        System.out.println(sol.isAnagram_hashMap(s, t)); // true
        System.out.println(sol.isAnagram_hashTable(s, t)); // true
    }
}