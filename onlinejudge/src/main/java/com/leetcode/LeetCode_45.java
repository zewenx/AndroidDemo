package com.leetcode;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/26 上午10:43
 */
public class LeetCode_45 {
    public static void main(String args[]) {
        System.out.println(new LeetCode_45().jump(new int[]{1,3,1,4,7,2,1,4,1}));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 1;
        int start = 0;
        int end = nums[0];
        while (end < nums.length - 1) {
            int newend = getMaxlength(start, end, nums);
            start = end;
            end = newend;
            count++;
        }

        return count;
    }

    private int getMaxlength(int start, int end, int[] nums) {
        int ans = 0;
        for (int i = start + 1; i <= end; i++) {
            ans = Math.max(ans, i + nums[i]);
        }
        return ans;
    }

}
