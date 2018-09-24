class Solution:
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if len(triangle) == 0:
            return 0
        if len(triangle) == 1:
            return triangle[0][0]

        pre = [triangle[0][0]]
        for i in range(1, len(triangle)):
            now = [triangle[i][0] + pre[0]]
            for j in range(1, len(triangle[i]) - 1):
                now.append(min(pre[j] + triangle[i][j], pre[j - 1] + triangle[i][j]))
            now.append(triangle[i][-1] + pre[-1])
            pre = now
        ans = now[0]
        for i in now:
            ans = min(i, ans)
        return ans


input = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]

print(Solution().minimumTotal(input))
