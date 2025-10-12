# Approach 1: Sorting
# Time complexity: O(n log n) initialize dictionary for count and list for sort + sort the list
# Space complexity: O(n) count and list for sort.

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)

        arr = []
        for num, cnt in count.items():
            arr.append([cnt, num])
        arr.sort()

        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        return res

# Approach 2-1: Min-Heap
# Time complexity: O(n log k) build a frequency map in O(n) + maintain a min-heap of size k to track top frequencies in O(m log k) + extract result in O(k)
# Space complexity: O(n + k) count + heap

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for n in nums:
            count[n] = count.get(n, 0) + 1

        heap = []
        for num, cnt in count.items():
            heapq.heappush(heap, (cnt, num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res


# Approach 2-2: Heap (Counter)
# Time complexity: O(n log k) build a frequency map in O(n) + maintain a min-heap of size k to track top frequencies in O(m log k) + extract result in O(k)
# Space complexity: O(n + k) count + heap

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = collections.Counter(nums)
        return [l[0] for l in count.most_common(k)]

# Approach 3: Bucket Sort
# Time complexity: O(n)
# Space complexity: O(n) for count(n) + freq(n+1)

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        freq = [[] for i in range(len(nums) + 1)]

        for num in nums:
            count[num] = 1 + count.get(num, 0)
        for num, cnt in count.items():
            freq[cnt].append(num)

        res = []
        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
