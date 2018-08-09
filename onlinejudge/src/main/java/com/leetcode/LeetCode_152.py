class Solution:
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        maxp = minp = ans = nums[0]

        for i in range(1, len(nums)):
            maxp, minp = max(nums[i] * minp, nums[i] * maxp, nums[i]), min(nums[i] * minp, nums[i] * maxp, nums[i])
            ans = max(ans, maxp)
        return ans


print(Solution().maxProduct([-1, -2, -9, -6]))
