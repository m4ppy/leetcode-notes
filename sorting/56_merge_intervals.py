# Approach 1: Sorting
# Time complexity: O(n log n)  
# Space complexity: 
#   O(1) or O(n) depending on sorting algorithm
#   O(n) for output list

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])

        output = [intervals[0]]

        for start, end in intervals:
            lastEnd = output[-1][1]

            if lastEnd >= start:
                output[-1][1] = max(end, lastEnd)
            else:
                output.append([start, end])
                
        return output
