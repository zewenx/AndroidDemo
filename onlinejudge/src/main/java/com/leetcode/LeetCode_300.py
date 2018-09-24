# Input: [8,9,2,5,3,7,101,18]
# Output: 4
# Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

class Solution:
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        f = [1] * len(nums)
        max_num = 1
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    f[i] = max(f[j] + 1, f[i])
                    if f[i] > max_num:
                        max_num = f[i]
        return max_num


print(Solution().lengthOfLIS([8, 9, 2, 5, 3, 7, 101, 111, 19, 18]))
