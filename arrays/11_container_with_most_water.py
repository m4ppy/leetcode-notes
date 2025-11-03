class Solution:
    def maxArea(self, heights: List[int]) -> int:
        res = 0
        for i in range(len(heights)):
            for j in range(i + 1, len(heights)):
                res = max(res, min(heights[i], heights[j]) * (j - i))
        return res


class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights) - 1
        res = 0

        while left < right:
            l_height, r_height = heights[left], heights[right]

            if l_height < r_height:
                area = l_height * (right - left)
                left += 1
            else:
                area = r_height * (right - left)
                right -= 1
            res = max(area, res)

        return res


class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l, r = 0, len(heights) - 1
        res = 0

        while l < r:
            area = min(heights[l], heights[r]) * (r - l)
            res = max(area, res)

            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1

        return res
