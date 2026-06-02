/*
LeetCode 1. Two Sum
Link: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Primary: hashmaps
Tags: [array, hashmap, prefix-sum]
Solved: 2025-10-01
*/

#include <stdio.h>
#include <stdlib.h>

#define TABLE_SIZE 10007


// --- Approach 1: Brute Force ---
// Time: O(n²), Space: O(1)
int* twoSum_bruteForce(int* nums, int numsSize, int target, int* returnSize) {
    for (int i = 0; i < numsSize - 1; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                int* result = (int*)malloc(sizeof(int) * 2);

                result[0] = i;
                result[1] = j;

                *returnSize = 2;
                return result;
            }
        }
    }

    *returnSize = 0;
    return NULL;
}


// --- Approach 2: Hash Map (Optimal) ---
// Time: O(n), Space: O(n)
typedef struct Node {
    int key;
    int value;
    struct Node* next;
} Node;

int hash(int key) {
    long long k = key;

    if (k < 0) {
        k = -k;
    }

    return k % TABLE_SIZE;
}

Node* find(Node** table, int key) {
    int idx = hash(key);
    Node* current = table[idx];

    while (current) {
        if (current->key == key) {
            return current;
        }

        current = current->next;
    }

    return NULL;
}

void insert(Node** table, int key, int value) {
    int idx = hash(key);

    Node* node = (Node*)malloc(sizeof(Node));

    node->key = key;
    node->value = value;
    node->next = table[idx];

    table[idx] = node;
}

void freeTable(Node** table) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Node* current = table[i];

        while (current) {
            Node* temp = current;
            current = current->next;
            free(temp);
        }
    }
}

int* twoSum_hashMap(int* nums, int numsSize, int target, int* returnSize) {
    Node* table[TABLE_SIZE] = {0};

    for (int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];

        Node* found = find(table, complement);

        if (found) {
            int* result = (int*)malloc(sizeof(int) * 2);

            result[0] = found->value;
            result[1] = i;

            *returnSize = 2;

            freeTable(table);
            return result;
        }

        insert(table, nums[i], i);
    }

    freeTable(table);

    *returnSize = 0;
    return NULL;
}


// --- Example Test ---
int main() {
    int nums[] = {2, 7, 11, 15};
    int target = 9;

    int returnSize = 0;

    int* result = twoSumHashMap(
        nums,
        sizeof(nums) / sizeof(nums[0]),
        target,
        &returnSize
    );

    if (result) {
        printf("[%d, %d]\n", result[0], result[1]);
        free(result);
    } else {
        printf("[]\n");
    }

    return 0;
}