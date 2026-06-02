/*
LeetCode 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/
Difficulty: Easy
Primary: hashmap
Tags: [string, hashmap, sorting]
Solved: 2026-06-02
*/

#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

#define TABLE_SIZE 128


// --- Approach 1: Sorting ---
// Time: O(n²), Space: O(1)
int compareChar(const void *a, const void *b) {
    return (*(char *)a - *(char *)b);
}

bool isAnagram_sorting(char* s, char* t) {
    int lenS = strlen(s);
    int lenT = strlen(t);

    if (lenS != lenT) {
        return false;
    }

    // Create copies because qsort modifies the array
    char *sCopy = (char *)malloc((lenS + 1) * sizeof(char));
    char *tCopy = (char *)malloc((lenT + 1) * sizeof(char));

    strcpy(sCopy, s);
    strcpy(tCopy, t);

    qsort(sCopy, lenS, sizeof(char), compareChar);
    qsort(tCopy, lenT, sizeof(char), compareChar);

    bool result = (strcmp(sCopy, tCopy) == 0);

    free(sCopy);
    free(tCopy);

    return result;
}


// --- Approach 2: Hash Map ---
// Time: O(n), Space: O(1)
typedef struct Node {
    char key;
    int value;
    struct Node* next;
} Node;

int hash(char key) {
    return key % TABLE_SIZE;
}

void put(Node* table[], char key) {
    int index = hash(key);

    Node* cur = table[index];

    while (cur != NULL) {
        if (cur->key == key) {
            cur->value++;
            return;
        }
        cur = cur->next;
    }

    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->key = key;
    newNode->value = 1;
    newNode->next = table[index];
    table[index] = newNode;
}

int get(Node* table[], char key) {
    int index = hash(key);

    Node* cur = table[index];

    while (cur != NULL) {
        if (cur->key == key) {
            return cur->value;
        }
        cur = cur->next;
    }

    return 0;
}

void freeTable(Node* table[]) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Node* cur = table[i];

        while (cur != NULL) {
            Node* temp = cur;
            cur = cur->next;
            free(temp);
        }
    }
}

bool isAnagram_hashMap(char* s, char* t) {
    if (strlen(s) != strlen(t)) {
        return false;
    }

    Node* countS[TABLE_SIZE] = {NULL};
    Node* countT[TABLE_SIZE] = {NULL};

    for (int i = 0; s[i] != '\0'; i++) {
        put(countS, s[i]);
        put(countT, t[i]);
    }

    for (int i = 0; s[i] != '\0'; i++) {
        if (get(countS, s[i]) != get(countT, s[i])) {
            freeTable(countS);
            freeTable(countT);
            return false;
        }
    }

    freeTable(countS);
    freeTable(countT);
    return true;
}


// --- Approach 3: Hash Table (Array) ---
// Time: O(n), Space: O(1)
bool isAnagram_hashTable(char* s, char* t) {
    if (strlen(s) != strlen(t)) {
        return false;
    }

    int count[26] = {0};

    for (int i = 0; s[i] != '\0'; i++) {
        count[s[i] - 'a']++;
        count[t[i] - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
        if (count[i] != 0) {
            return false;
        }
    }

    return true;
}