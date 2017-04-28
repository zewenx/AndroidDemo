package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:43
 */
public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int max_sub = nums[0];
        int max_temp = nums [0];
        for (int i = 1;i<nums.length;i++){
            if (max_temp<0)max_temp = 0;
            max_temp+=nums[i];
            max_sub = Math.max(max_sub,max_temp);
        }
        return max_sub;
    }
}
